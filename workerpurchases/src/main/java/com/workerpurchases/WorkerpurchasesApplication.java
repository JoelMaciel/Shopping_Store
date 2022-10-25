package com.workerpurchases;

import com.workerpurchases.service.CepService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableRabbit
@SpringBootApplication
public class WorkerpurchasesApplication {

    @Autowired
    private CepService cepService;

    public static void main(String[] args) {
        SpringApplication.run(WorkerpurchasesApplication.class, args);
    }

    @Bean
    void teste(){
        cepService.findByCep("61645340");
    }

}
