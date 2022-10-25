package com.workerpurchases.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order implements Serializable {


    private Long id;
    private String name;
    private Long product;
    private BigDecimal valueProduct;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date purchaseDate;
    private String cpfClient;
    private String cep;
    private String email;

    private Card card;
}

















