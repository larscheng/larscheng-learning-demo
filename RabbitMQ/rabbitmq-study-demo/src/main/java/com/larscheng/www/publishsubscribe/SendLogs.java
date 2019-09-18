package com.larscheng.www.publishsubscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 描述:
 * 日志发送
 *
 * @author zhengql
 * @date 2019/9/18 15:05
 */

@Slf4j
public class SendLogs {
    private static String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                //创建链接、频道
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            //声明交换机类型和名称
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String msg = System.currentTimeMillis()+" => info: Hello World!";
            //将消息发送至交换机（而非队列）
            channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
            log.info("发送日志到exchange:{}",EXCHANGE_NAME);

        }
    }
}
