package com.github.lucasbezq.ms_cards.domain.service;

import com.github.lucasbezq.ms_cards.domain.model.Card;
import com.github.lucasbezq.ms_cards.domain.model.CustomerCard;
import com.github.lucasbezq.ms_cards.domain.repository.CardRepository;
import com.github.lucasbezq.ms_cards.domain.repository.CustomerCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {

    private final CustomerCardRepository repository;

    public List<CustomerCard> findCardsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
