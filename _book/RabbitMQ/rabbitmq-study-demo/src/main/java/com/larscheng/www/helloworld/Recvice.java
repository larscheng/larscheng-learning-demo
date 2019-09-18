package com.larscheng.www.helloworld;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 描述:
 * 消息接收者
 *
 * @author lars
 * @date 2019/7/24 13:23
 */
@Slf4j
public class Recvice {
    private final static String QUEUE_NAME = "HELLO";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //创建链接、频道
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        DeliverCallback deliverCallback = (consumerTag,delivery) ->{
            String msg = new String(delivery.getBody(),"UTF-8");
            log.info("从队列：{} 中收到消息：{}",QUEUE_NAME,msg);
        };

        //true 为自动应答，会存在丢失消息的情况
        boolean autoAck = true;
        //指定消费队列
        channel.basicConsume(QUEUE_NAME,autoAck,deliverCallback,consumerTag->{});
    }
}
