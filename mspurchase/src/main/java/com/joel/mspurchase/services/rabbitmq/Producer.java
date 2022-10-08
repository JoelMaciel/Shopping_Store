package com.joel.mspurchase.services.rabbitmq;

import com.joel.mspurchase.models.Order;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class Producer {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @PostMapping
    public void sendRequest(Order order) {
        rabbitTemplate.convertAndSend(queue.getName(), order);
    }
}
