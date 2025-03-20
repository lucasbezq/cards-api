package com.github.lucasbezq.ms_cards.api.converter;

import com.github.lucasbezq.ms_cards.api.dto.CustomerCardDTO;
import com.github.lucasbezq.ms_cards.domain.model.CustomerCard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerCardDTOConverter {

    public CustomerCardDTO toDTO(CustomerCard customerCard) {
        return new CustomerCardDTO(
                customerCard.getId(),
                customerCard.getCard().getName(),
                customerCard.getCpf(),
                customerCard.getBasicLimit()
        );
    }

    public List<CustomerCardDTO> toCollectionDTO(List<CustomerCard> customerCards) {
        return customerCards.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
