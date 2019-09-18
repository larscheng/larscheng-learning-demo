package com.larscheng.www.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 描述:
 * 打印日志
 *
 * @author zhengql
 * @date 2019/9/18 15:14
 */
@Slf4j
public class WriteLogs {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //创建一个非持久的、唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        System.out.println(queueName + ".........");
        //为转发器指定队列，设置binding
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            log.info("【日志收集器2】收到来自交换机:{}，的消息:{}", delivery.getEnvelope().getExchange(), message);

        };

        //指定消费队列，并自动回复
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});

    }
}
