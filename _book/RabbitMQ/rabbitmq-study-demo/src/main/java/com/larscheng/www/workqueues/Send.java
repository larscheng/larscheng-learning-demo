package com.larscheng.www.workqueues;

import com.rabbitmq.client.*;
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
    private final static String TASK_QUEUE_NAME = "TASK_QUEUE";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                //创建链接、频道
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            //声明队列持久
            boolean durable = true;
            //指定一个队列(持久化队列只能在初始化时定义，已存在已创建的队列无效)
            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

            //发送10条消息，依次在消息后面附加1-10个点
            StringBuilder stringBuilder = new StringBuilder("workqueues");
            for (int i = 1; i <= 10; i++){
                stringBuilder.append(".");
                String msg = stringBuilder.toString()+i;


                //将消息标记为持久性
                AMQP.BasicProperties basicProperties = MessageProperties.PERSISTENT_TEXT_PLAIN;
                //向队列中发送消息
                channel.basicPublish("", TASK_QUEUE_NAME, basicProperties, msg.getBytes());
                log.info("发送消息：{} 到队列：{}", msg, TASK_QUEUE_NAME);
            }
        }
    }
}
