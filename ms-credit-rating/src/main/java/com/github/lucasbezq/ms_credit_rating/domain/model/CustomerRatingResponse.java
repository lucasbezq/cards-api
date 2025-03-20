package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerRatingResponse {

    private List<ApprovedCard> cards;

    public CustomerRatingResponse(List<ApprovedCard> approvedCards) {
        this.cards = approvedCards;
    }

}
