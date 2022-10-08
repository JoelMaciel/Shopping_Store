package com.joel.mspurchase.services;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.repositories.OrderRepository;
import com.joel.mspurchase.services.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository requestRepository;
    private final Producer producer;

    public Order save(Order order) {
        var savedOrder = requestRepository.save(order);
        producer.sendRequest(savedOrder);
        return savedOrder;

    }
}
