package com.github.lucasbezq.ms_credit_rating.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.cards-issue}")
    private String cardIssueQueue;

    @Bean
    public Queue cardIssue() {
        return new Queue(cardIssueQueue, true);
    }

}
