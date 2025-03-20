package com.github.lucasbezq.ms_cards.api.converter;

import com.github.lucasbezq.ms_cards.api.dto.CardSaveRequest;
import com.github.lucasbezq.ms_cards.domain.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardConverter {

    public Card toModel(CardSaveRequest request) {
        var card = new Card();
        card.setName(request.name());
        card.setBrand(request.brand());
        card.setIncome(request.income());
        card.setBasicLimit(request.limit());

        return card;
    }
}
