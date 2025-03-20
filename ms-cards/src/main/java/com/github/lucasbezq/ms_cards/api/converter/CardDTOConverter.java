package com.github.lucasbezq.ms_cards.api.converter;

import com.github.lucasbezq.ms_cards.api.dto.CardDTO;
import com.github.lucasbezq.ms_cards.domain.model.Card;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardDTOConverter {

    public CardDTO toDTO(Card card) {
        return new CardDTO(
                card.getId(),
                card.getName(),
                card.getBrand().name(),
                card.getIncome(),
                card.getBasicLimit()
        );
    }

    public List<CardDTO> toCollectionDTO(List<Card> cards) {
        return cards.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
