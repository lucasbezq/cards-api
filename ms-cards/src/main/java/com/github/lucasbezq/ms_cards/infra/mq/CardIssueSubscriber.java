package com.github.lucasbezq.ms_cards.infra.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lucasbezq.ms_cards.api.converter.CustomerCardDTOConverter;
import com.github.lucasbezq.ms_cards.api.dto.RequestCardData;
import com.github.lucasbezq.ms_cards.domain.model.CustomerCard;
import com.github.lucasbezq.ms_cards.domain.repository.CardRepository;
import com.github.lucasbezq.ms_cards.domain.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CardIssueSubscriber {

    private final CardRepository cardRepository;
    private final CustomerCardRepository customerCardRepository;

    @RabbitListener(queues = "${mq.queues.cards-issue}")
    public void receive(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            var data = mapper.readValue(payload, RequestCardData.class);
            var card = cardRepository.findById(data.getIdCard()).orElseThrow();

            //TODO: move to converter
            var customerCard = new CustomerCard();
            customerCard.setCard(card);
            customerCard.setCpf(data.getCpf());
            customerCard.setBasicLimit(data.getApprovedLimit());

            customerCardRepository.save(customerCard);
        } catch (Exception e) {
            log.error("Error when receiving card issuance request: [{}]", e.getMessage());
        }
    }

}
