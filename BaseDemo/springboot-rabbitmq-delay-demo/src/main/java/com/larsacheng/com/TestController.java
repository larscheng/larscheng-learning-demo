package com.larsacheng.com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/2/26 15:13
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    @RabbitHandler
//    @RabbitListener(queues = RabbitMqConfig.QUEUE_DEAD_LETTER)
//    public void processDead2(String msg) {
//        log.info("延时队列收到消息:  {}", msg);
//    }

    /***
     *
     * 监听死信队列(正真接收延时任务的队列)
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(queues = RabbitMqConfig.QUEUE_DEAD_LETTER)
    public void processDead(String msg) {
        String time = msg.split(":")[1];
        long delay = System.currentTimeMillis() - Long.parseLong(time);
        log.info("延时队列收到消息:  {},延时时间: {}ms", msg, delay);
    }


    /***
     * 发送消息到指定ttl的队列
     * @throws InterruptedException
     */
    @RequestMapping("/send/delay/queue")
    public void sendDelay() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            this.rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NORMAL_TEST_01, RabbitMqConfig.NORMAL_KEY,
                    "第" + i + "个消息: " + new Date());
            Thread.sleep(1000);
        }
        log.info("消息已发送成功.....");
    }


    /**
     * 发送消息到未指定ttl的队列，但是每条消息进行ttl设置
     *
     * @throws InterruptedException
     */
    @RequestMapping("/send/delay/time")
    public void sendDelayTime() throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            this.rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NORMAL_TEST_02, RabbitMqConfig.NORMAL_KEY,
                    "第" + i + "个消息: " + new Date(),
                    message -> {
                        message.getMessageProperties().setExpiration("10000");
                        return message;
                    }
            );
            Thread.sleep(1000);
        }
        log.info("自定义消息存活时间已发送成功.....");
    }


    /**
     * 发送消息到未指定ttl的队列，但是每条消息进行ttl设置
     */
    @RequestMapping("/send/delay/differ/time")
    public void sendDelayDifferTime() {
        for (int i = 1; i <= 5; i++) {
            int finalI = i * 10000;
            this.rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NORMAL_TEST_02, RabbitMqConfig.NORMAL_KEY,
                    "第" + i + "个消息:" + System.currentTimeMillis(),
                    message -> {
                        message.getMessageProperties().setExpiration(String.valueOf(finalI));
                        return message;
                    }
            );
        }
        log.info("自定义消息存活时间(小->大)已发送成功.....");
    }

    /**
     * 发送消息到未指定ttl的队列，但是每条消息进行ttl设置
     */
    @RequestMapping("/send/delay/differ/time2")
    public void sendDelayDifferTime2() {
        for (int i = 5; i >= 1; i--) {
            int finalI = i * 3000;
            this.rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NORMAL_TEST_02, RabbitMqConfig.NORMAL_KEY,
                    "第" + i + "个消息:" + System.currentTimeMillis(),
                    message -> {
                        message.getMessageProperties().setExpiration(String.valueOf(finalI));
                        return message;
                    }
            );
        }
        log.info("自定义消息存活时间(大->小)已发送成功.....");
    }

    /*************************基于插件实现延时队列（rabbitmq_delayed_message_exchange）*************************************/

    @RequestMapping("/send/delay/differ/time3")
    public void sendDelayDifferTime3() {
        for (int i = 5; i >= 1; i--) {
            int finalI = i * 10000;
            this.rabbitTemplate.convertAndSend(DelayExchangeConfig.DELAYED_EXCHANGE_NAME, DelayExchangeConfig.DELAYED_ROUTING_KEY,
                    "第" + i + "个消息:" + System.currentTimeMillis(),
                    message -> {
                        message.getMessageProperties().setDelay(finalI);
                        return message;
                    }
            );
        }
        log.info("自定义消息存活时间(大->小)已发送成功.....");
    }

    /***
     *
     * 监听死信队列(正真接收延时任务的队列)
     * @param msg
     */
    @RabbitHandler
    @RabbitListener(queues = DelayExchangeConfig.DELAYED_QUEUE_NAME)
    public void processDelay(String msg) {
        String time = msg.split(":")[1];
        long delay = System.currentTimeMillis() - Long.parseLong(time);
        log.info("延时队列收到消息:  {},延时时间: {}ms", msg, delay);
    }
}
