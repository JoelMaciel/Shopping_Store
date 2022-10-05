package com.joel.mspurchase.controllers;

import com.joel.mspurchase.models.Request;
import com.joel.mspurchase.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/requests")
public class RequestController {
    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody @Valid Request request) {
        requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
