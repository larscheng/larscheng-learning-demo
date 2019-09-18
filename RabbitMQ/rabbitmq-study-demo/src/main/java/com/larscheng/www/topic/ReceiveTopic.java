package com.larscheng.www.topic;

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
public class ReceiveTopic {

    private static String EXCHANGE_NAME = "topic_exchange";
    private static final String[] TOPIC = {"he.*.*", "he.#", "*.is.*"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //创建一个非持久的、唯一的且自动删除的队列
        String queueName = channel.queueDeclare().getQueue();
        String routingKey = TOPIC[0];
        System.out.println(queueName + ".........等待【" + routingKey + "】消息");
        //为转发器指定队列，设置binding，设置binding_key

        channel.queueBind(queueName, EXCHANGE_NAME, routingKey);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            log.info("【topics收集器1】：收到来自交换机:{},队列：{} 的消息:{}", delivery.getEnvelope().getExchange(),
                    delivery.getEnvelope().getRoutingKey(), message);
        };

        //指定消费队列，并自动回复
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }
}
