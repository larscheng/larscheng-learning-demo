package com.larscheng.www.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
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
public class Worker {
    private final static String TASK_QUEUE_NAME = "TASK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //创建链接、频道
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);
        System.out.println("接收消息中........");

        DeliverCallback deliverCallback = (consumerTag,delivery) ->{
            String msg = new String(delivery.getBody(),"UTF-8");
            log.info("工作者：{} 从队列：{} 中收到消息：{}",Thread.currentThread().getName(),TASK_QUEUE_NAME,msg);
            Long start = System.currentTimeMillis();
            for (char s : msg.toCharArray()){
                if (s=='.') {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            log.info("工作者：{} 本次任务处理完成,耗时：{}ms",Thread.currentThread().getName(),System.currentTimeMillis()-start);
            //手动确认
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };

        //true 为自动应答，会存在丢失消息的情况
        boolean autoAck = false;
        //指定消费队列
        channel.basicConsume(TASK_QUEUE_NAME,autoAck,deliverCallback,consumerTag->{});
    }
}
