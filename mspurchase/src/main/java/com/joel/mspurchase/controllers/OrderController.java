package com.joel.mspurchase.controllers;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService requestService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        requestService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
