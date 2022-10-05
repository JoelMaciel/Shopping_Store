package com.joel.mspurchase.services;

import com.joel.mspurchase.models.Request;
import com.joel.mspurchase.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RequestService {
    private final  RequestRepository requestRepository;

    public Request save(Request request) {
        return requestRepository.save(request);

    }
}
