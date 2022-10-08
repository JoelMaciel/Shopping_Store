package com.joel.mspurchase.services.rabbitmq;

import com.joel.mspurchase.models.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Consumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Order order){
        System.out.printf("Message received: " + order);

    }
}
