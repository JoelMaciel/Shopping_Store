package com.msvalidator;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MsvalidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvalidatorApplication.class, args);
    }

}
