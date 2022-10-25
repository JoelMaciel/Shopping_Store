package com.workerpurchases.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardService {

    public  String generateCard() {
        var sequence1 = new BigDecimal(1000 + (long)(Math.random() * 500));
        var sequence2 = new BigDecimal(2000 + (long)(Math.random() * 500));
        var sequence3 = new BigDecimal(3000 + (long)(Math.random() * 500));
        var sequence4 = new BigDecimal(4000 + (long)(Math.random() * 500));

        return sequence1 + " " + sequence2 + " " + sequence3 + " " + sequence4;
    }

    public BigDecimal genetareLimit() {
        return new BigDecimal(1000 + (long)(Math.random() * 500));
    }
}
