package com.github.lucasbezq.ms_cards.domain.service;

import com.github.lucasbezq.ms_cards.domain.model.Card;
import com.github.lucasbezq.ms_cards.domain.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card save(Card card) {
        return repository.save(card);
    }

    public List<Card> findIncomeLessThanEqual(Long income) {
        var incomeFormatted = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeFormatted);
    }
}
