package com.github.lucasbezq.ms_credit_rating.infra.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.lucasbezq.ms_credit_rating.domain.model.RequestCardData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestCardPublisher {

    private final RabbitTemplate template;
    private final Queue cardIssueQueue;

    public void requestCard(RequestCardData data) throws JsonProcessingException {
        var json = convertIntoJson(data);
        template.convertAndSend(cardIssueQueue.getName(), json);
    }

    private String convertIntoJson(RequestCardData data) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }

}
