package com.joel.mspurchase.services;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.repositories.OrderRepository;
import com.joel.mspurchase.services.exception.BusinessException;
import com.joel.mspurchase.services.exception.EntityNotFoundException;
import com.joel.mspurchase.services.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final Producer producer;

    public Order save(Order order) {
        var savedOrder = orderRepository.save(order);
     producer.sendOrder(savedOrder);
        return savedOrder;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "The id request : " + id + " does not exists in the database") {
        });
    }

    public void delete(Long id) {
        var order = findById(id);
        orderRepository.deleteById(order.getId());
    }
}














