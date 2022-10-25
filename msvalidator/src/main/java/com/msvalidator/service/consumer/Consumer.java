package com.msvalidator.service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msvalidator.models.Order;
import com.msvalidator.service.ValidatorService;
import com.msvalidator.service.exception.InsufficientBalanceException;
import com.msvalidator.service.exception.LimitUnavailableException;
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
        } catch (LimitUnavailableException | InsufficientBalanceException exception) {
            exception.printStackTrace();
        }
    }
}





















