package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApprovedCard {

    private String card;
    private String brand;
    private BigDecimal approvedLimit;

}
