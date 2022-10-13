package com.workerpurchases.service;

import com.workerpurchases.repositories.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public void findByCep(String cep){
       var address = cepRepository.findByCep(cep);
        System.out.println(address);
    }
}
