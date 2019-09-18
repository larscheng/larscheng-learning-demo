package com.larscheng.www.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 * 消息发布者
 *
 * @author lars
 * @date 2019/7/24 11:35
 */
@Slf4j
public class Send {
    private final static String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                //创建链接、频道
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            //指定一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            //定义要发送的消息
            String msg = "hello-world";
            //向队列中发送消息
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            log.info("发送消息：{} 到队列：{}", msg, QUEUE_NAME);
        }

    }
}
