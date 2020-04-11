package com.larscheng.www;

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

/**
 * 描述:
 * rabbitmq配置类
 *
 * @author larscheng
 * @date 2020/2/26 14:18
 */
@Component
public class RabbitMqConfig {

    final static String DIRECT_EXCHANGE_NAME = "exchange_direct_test_001";
    final static String DIRECT_QUEUE_NAME = "queue_direct_test_001";
    final static String ROUTING_KEY = "larscheng";

    /**
     * 创建direct交换机,路由模式
     *
     * @return
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    /**
     * 创建queue
     *
     * @return
     */
    @Bean
    public Queue queue() {
        //名字 是否持久化
        return new Queue(DIRECT_QUEUE_NAME, true);
    }

    /**
     * directQueue 绑定路由建
     *
     * @return
     */
    @Bean
    public Binding binding() {
        //绑定一个队列 to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(ROUTING_KEY);
    }


    @Bean
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置broker确认回调
        rabbitTemplate.setConfirmCallback(new MyConfirmCallback());
        //开启失败回调（队列分发失败）
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new MyReturnCallback());
        setMessageConverter(rabbitTemplate);
        return rabbitTemplate;
    }

    /***
     * 设置消息格式
     * @param rabbitTemplate
     */
    private void setMessageConverter(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMessageConverter(new MessageConverter() {
            @Override
            public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
                messageProperties.setContentType("text/xml");
                messageProperties.setContentEncoding("UTF-8");
                return new Message(JSON.toJSONBytes(o), messageProperties);
            }

            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                return null;
            }
        });
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

}