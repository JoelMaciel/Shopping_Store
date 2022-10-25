package com.workerpurchases.service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workerpurchases.models.Order;
import com.workerpurchases.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@Component
public class Consumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Message message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        var order = mapper.readValue(message.getBody(), Order.class);
        log.info("Order received : {}", order);
        emailService.notificationClient(order);

    }
}
