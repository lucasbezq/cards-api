package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerCard {

    private Long id;
    private String name;
    private String brand;
    private BigDecimal limit;

}
