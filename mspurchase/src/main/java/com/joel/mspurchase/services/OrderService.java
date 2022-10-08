package com.joel.mspurchase.services;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.repositories.RequestRepository;
import com.joel.mspurchase.services.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RequestService {
    private final  RequestRepository requestRepository;
    private final Producer producer;

    public Order save(Order request) {
        var savedOrder = requestRepository.save(request);
        producer.sendRequest(savedOrder);
        return savedOrder;

    }
}
