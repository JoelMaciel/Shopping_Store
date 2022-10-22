package com.joel.mspurchase.models;

import java.math.BigDecimal;
import java.util.Date;


public class OrderMock {

    public Order getOrder() {
        return Order.builder()
                .name("Joel Maciel")
                .product(1L)
                .valueProduct(BigDecimal.TEN)
                .purchaseDate(new Date())
                .cpfClient("123.456.789-101")
                .cep("61647895")
                .email("joel@gmail.com")
                .build();
    }
    public Order getOrderSaved() {
        return Order.builder()
                .id(1L)
                .name("Joel Maciel")
                .product(1L)
                .valueProduct(BigDecimal.TEN)
                .purchaseDate(new Date())
                .cpfClient("123.456.789-101")
                .cep("61647895")
                .email("joel@gmail.com")
                .build();
    }

}
