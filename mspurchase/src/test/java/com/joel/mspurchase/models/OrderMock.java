package com.joel.mspurchase.models;

import java.math.BigDecimal;
import java.util.Date;


public class OrderMock {

    public Order getOrder() {
        return Order.builder()
                .name("Joel TEST INTEGRATION")
                .product(1L)
                .valueProduct(BigDecimal.TEN)
                .purchaseDate(new Date())
                .cpfClient("518.246.380-43")
                .cep("61647795")
                .email("jmviana37@gmail.com")
                .build();
    }
    public Order getOrderSaved() {
        return Order.builder()
                .id(1L)
                .name("Joel TEST With Id")
                .product(1L)
                .valueProduct(BigDecimal.TEN)
                .purchaseDate(new Date())
                .cpfClient("111.540.140-88")
                .cep("61647895")
                .email("jmviana37@gmail.com")
                .build();
    }

}
