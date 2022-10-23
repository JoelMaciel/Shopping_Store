package com.joel.mspurchase.controllers;

import com.joel.mspurchase.models.Order;
import com.joel.mspurchase.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public ResponseEntity<Order> findById(@PathVariable Long id) {
       var orderId =  orderService.findById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(orderId);
    }
}

















