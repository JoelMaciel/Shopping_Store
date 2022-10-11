package com.workerpurchases.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workerpurchases.models.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import java.io.IOException;

@RequiredArgsConstructor
@Component
public class Consumer {
    ObjectMapper mapper = new ObjectMapper();

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Message message) throws IOException {
        var order = mapper.readValue(message.getBody(), Order.class);
        System.out.printf("Message received in Workerpurchases: " + order);

    }
}
