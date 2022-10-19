package com.msvalidator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvalidator.models.Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Log4j2
@Component
public class Consumer {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ValidatorService validatorService;

    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload Message message) throws IOException {
        var order = mapper.readValue(message.getBody(), Order.class);
        log.info("Order received in Validator : {} ", order);

        try {
            validatorService.validateOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





















