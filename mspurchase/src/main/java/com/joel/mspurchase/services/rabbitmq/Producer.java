package com.joel.mspurchase.services.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joel.mspurchase.models.Order;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper mapper;

    @SneakyThrows
    @PostMapping
    public void sendOrder(Order order) {
        rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(order));
    }
}
