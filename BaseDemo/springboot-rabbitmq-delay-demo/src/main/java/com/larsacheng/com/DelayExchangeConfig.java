package com.larsacheng.com;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 使用插件的延时队列实现
 *
 * @author larscheng
 * @date 2020/2/27 11:45
 */
@Component
public class DelayExchangeConfig {

    public static final String DELAYED_QUEUE_NAME = "delay.queue.plugins.delay.queue";
    public static final String DELAYED_EXCHANGE_NAME = "delay.queue.plugins.delay.exchange";
    public static final String DELAYED_ROUTING_KEY = "delay.key";

    @Bean
    public Queue delayQueue() {
        return new Queue(DELAYED_QUEUE_NAME);
    }

    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingNotify(@Qualifier("delayQueue") Queue queue,
                                 @Qualifier("customExchange") CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
