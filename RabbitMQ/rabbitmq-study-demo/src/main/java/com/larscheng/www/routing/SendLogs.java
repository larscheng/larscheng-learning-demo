package com.larscheng.www.routing;

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
public class SendLogs {

    private static String EXCHANGE_NAME = "direct_logs";
    private static final String[] LOG_LEVEL = {"info", "warning", "error"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                //创建链接、频道
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            //声明交换机类型和名称
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            for (int i = 0; i < 10; i++) {

                //随机发送不同级别日志
                String logLevel = LOG_LEVEL[new Random().nextInt(3)];
                String msg = System.currentTimeMillis() + " => " + logLevel + ": Hello World!";
                //将消息发送至交换机（而非队列）
                channel.basicPublish(EXCHANGE_NAME, logLevel, null, msg.getBytes());
                log.info("发送日志到exchange:{}，日志内容：{}", EXCHANGE_NAME, msg);

            }

        }
    }
}
