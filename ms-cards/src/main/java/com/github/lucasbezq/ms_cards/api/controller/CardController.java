package com.github.lucasbezq.ms_cards.api.controller;

import com.github.lucasbezq.ms_cards.api.converter.CardConverter;
import com.github.lucasbezq.ms_cards.api.converter.CardDTOConverter;
import com.github.lucasbezq.ms_cards.api.converter.CustomerCardDTOConverter;
import com.github.lucasbezq.ms_cards.api.dto.CardDTO;
import com.github.lucasbezq.ms_cards.api.dto.CardSaveRequest;
import com.github.lucasbezq.ms_cards.api.dto.CustomerCardDTO;
import com.github.lucasbezq.ms_cards.domain.service.CardService;
import com.github.lucasbezq.ms_cards.domain.service.CustomerCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CustomerCardService customerCardService;
    private final CardConverter cardConverter;
    private final CardDTOConverter cardDTOConverter;
    private final CustomerCardDTOConverter customerCardDTOConverter;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardDTO generate(@RequestBody CardSaveRequest request) {
        var card = cardConverter.toModel(request);
        return cardDTOConverter.toDTO(cardService.save(card));
    }

    @GetMapping
    public List<CardDTO> findIncomeLessThanEqual(@RequestParam("income") Long income) {
        return cardDTOConverter.toCollectionDTO(cardService.findIncomeLessThanEqual(income));
    }

    @GetMapping(params = "cpf")
    public List<CustomerCardDTO> getCardsByCustomer(@RequestParam("cpf") String cpf) {
        return customerCardDTOConverter.toCollectionDTO(customerCardService.findCardsByCpf(cpf));
    }
}
