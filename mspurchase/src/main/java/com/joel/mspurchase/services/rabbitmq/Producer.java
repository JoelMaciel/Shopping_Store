package com.joel.mspurchase.services.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.mspurchase.models.Order;
import lombok.SneakyThrows;
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

    @Autowired
    private ObjectMapper mapper;

    @SneakyThrows
    @PostMapping
    public void sendRequest(Order order) {
        rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(order));
    }
}
