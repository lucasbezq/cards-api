package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerSituation {

    private CustomerData customer;
    private List<CustomerCard> cards;

}
