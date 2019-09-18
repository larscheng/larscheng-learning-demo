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
            //【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            //定义要发送的消息
            String msg = "hello-world";
            //向队列中发送消息
            //【参数说明：参数一：交换机名称；参数二：队列名称，参数三：消息的其他属性-routing headers，此属性为MessageProperties.PERSISTENT_TEXT_PLAIN用于设置纯文本消息存储到硬盘；参数四：消息主体】
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            log.info("发送消息：{} 到队列：{}", msg, QUEUE_NAME);
        }

    }
}
