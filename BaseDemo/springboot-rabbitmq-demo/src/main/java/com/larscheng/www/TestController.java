package com.larscheng.www;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @RabbitHandler
    @RabbitListener(queues = RabbitMqConfig.DIRECT_QUEUE_NAME)
    public void process(String msg) {
        log.info("Receiver: {}", msg);
    }


    @RequestMapping("/send")
    public void send() {
        for (int i = 0; i < 20; i++) {
            this.rabbitTemplate.convertAndSend(RabbitMqConfig.DIRECT_EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, "第 " + i + " 个消息");
        }
    }

}
