package com.joel.mspurchase.controllers;

import com.joel.mspurchase.models.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
