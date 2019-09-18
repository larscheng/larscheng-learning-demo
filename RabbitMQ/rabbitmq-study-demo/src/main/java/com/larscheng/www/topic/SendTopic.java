package com.larscheng.www.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * 描述:
 * 生成日志
 *
 * @author zhengql
 * @date 2019/9/18 15:40
 */
@Slf4j
public class SendTopic {

    private static String EXCHANGE_NAME = "topic_exchange";
    private static final String[] TOPIC = {"he.is.handsome", "he.is.bad", "she.is.lonely","i.am.liming"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                //创建链接、频道
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            //声明交换机类型和名称
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            for (int i = 0; i < 10; i++) {

                //随机发送topic
                String routingKey = TOPIC[new Random().nextInt(4)];
                String msg = System.currentTimeMillis() + " => " + routingKey + ": Hello World!";
                //将消息发送至交换机（而非队列）
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
                log.info("发送日志到exchange:{}，日志内容：{}", EXCHANGE_NAME, msg);

            }

        }
    }
}
