package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestCardData {

    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;

}
