package com.workerpurchases.service.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workerpurchases.models.Card;
import com.workerpurchases.models.Order;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Log4j2
@Service
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ObjectMapper mapper;

    @SneakyThrows
    @PostMapping
    public void sendOrder(Order order) {
        order.setCard(Card.builder()
                .number("5148 5568 3056 8945")
                .availableLimit(new BigDecimal(1000))
                .build());

        rabbitTemplate.convertAndSend(queue.getName() , mapper.writeValueAsString(order));
        log.info("Order placed successfully in worker Purchase - OrderProducer : {} "  , mapper.writeValueAsString(order));
    }
}

















