package com.larsacheng.com;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * rabbitmq配置类
 *
 * @author larscheng
 * @date 2020/2/26 14:18
 */
@Component
public class RabbitMqConfig {


    @Bean
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //开启失败回调（队列分发失败）
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new MyReturnCallback());
        //设置broker确认回调
        rabbitTemplate.setConfirmCallback(new MyConfirmCallback());
        return rabbitTemplate;
    }


    private class MyReturnCallback implements RabbitTemplate.ReturnCallback {
        @Override
        public void returnedMessage(Message message, int i, String s, String s1, String s2) {
            System.out.println("队列发送失败回调------------> : " + message + "," + i + "," + s + "," + s1 + "," + s2);
        }
    }

    private class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {
        @Override
        public void confirm(CorrelationData correlationData, boolean b, String s) {
            if (!b) {
                System.out.println("Broker接收消息异常------------> : " + correlationData + "," + b + "," + s);
            }
        }
    }


    /******************************************延时队列****************************************************/


    final static String EXCHANGE_NORMAL_TEST_02 = "exchange_no_ttl";
    final static String QUEUE_NORMAL_TEST_02 = "queue_no_ttl";
    final static String EXCHANGE_NORMAL_TEST_01 = "exchange_have_ttl_10s";
    final static String QUEUE_NORMAL_TEST_01 = "queue_have_ttl_10s";
    final static String NORMAL_KEY = "normal.key";

    /**
     * 死信交换机和队列以及路由key
     */
    final static String EXCHANGE_DEAD_LETTER = "exchange_dead_letter";
    final static String QUEUE_DEAD_LETTER = "queue_delay_msg";
    final static String DEAD_KEY = "dead.key";


    /**
     * 创建正常的direct交换机
     *
     * @return
     */
    @Bean
    public DirectExchange normalExchange01() {
        return new DirectExchange(EXCHANGE_NORMAL_TEST_01);
    }

    /**
     * ttl:在队列进行设置  10s
     */
    @Bean
    public Queue queueNormal01() {
        Map<String, Object> map = new HashMap<>();
        //设置队列中所有消息的过期时间 单位毫秒
        map.put("x-message-ttl", 10000);
        //设置附带的死信交换机
        map.put("x-dead-letter-exchange", EXCHANGE_DEAD_LETTER);
        //指定重定向的路由建 消息作废之后可以决定需不需要更改他的路由建 如果需要 就在这里指定
        map.put("x-dead-letter-routing-key", DEAD_KEY);
        return new Queue(QUEUE_NORMAL_TEST_01, true, false, false, map);
    }

    @Bean
    public Binding bindingNormal01() {
        //绑定一个队列 to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queueNormal01()).to(normalExchange01()).with(NORMAL_KEY);
    }

    @Bean
    public DirectExchange normalExchange02() {
        return new DirectExchange(EXCHANGE_NORMAL_TEST_02);
    }

    /**
     * ttl:在每条消息进行设置
     */
    @Bean
    public Queue queueNormal02() {
        Map<String, Object> map = new HashMap<>();
        //设置附带的死信交换机
        map.put("x-dead-letter-exchange", EXCHANGE_DEAD_LETTER);
        //指定重定向的路由建 消息作废之后可以决定需不需要更改他的路由建 如果需要 就在这里指定
        map.put("x-dead-letter-routing-key", DEAD_KEY);
        return new Queue(QUEUE_NORMAL_TEST_02, true, false, false, map);
    }

    @Bean
    public Binding bindingNormal02() {
        //绑定一个队列 to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queueNormal02()).to(normalExchange02()).with(NORMAL_KEY);
    }


    /**
     * 创建死信交换机
     *
     * @return
     */
    @Bean
    public TopicExchange exchangeDeadLetter() {
        return new TopicExchange(EXCHANGE_DEAD_LETTER);
    }

    /***
     * 死信队列（真正执行延时业务的地方）
     * @return
     */
    @Bean
    public Queue deadLetterQueue() {
        return new Queue(QUEUE_DEAD_LETTER);
    }

    /***
     * 绑定死信对列和死信交换机
     * @return
     */
    @Bean
    public Binding bindingDead() {
        return BindingBuilder.bind(deadLetterQueue()).to(exchangeDeadLetter()).with(DEAD_KEY);
    }


}