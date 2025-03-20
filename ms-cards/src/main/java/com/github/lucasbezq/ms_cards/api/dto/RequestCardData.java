package com.github.lucasbezq.ms_cards.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestCardData {

    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;

}
