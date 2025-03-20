package com.github.lucasbezq.ms_credit_rating.domain.service;

import com.github.lucasbezq.ms_credit_rating.domain.exception.CustomerDataNotFoundException;
import com.github.lucasbezq.ms_credit_rating.domain.exception.CustomerServiceException;
import com.github.lucasbezq.ms_credit_rating.domain.exception.RequestCardException;
import com.github.lucasbezq.ms_credit_rating.domain.model.*;
import com.github.lucasbezq.ms_credit_rating.infra.feign.CardsClient;
import com.github.lucasbezq.ms_credit_rating.infra.feign.CustomerClient;
import com.github.lucasbezq.ms_credit_rating.infra.mq.RequestCardPublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditRatingService {

    private final CustomerClient customerClient;
    private final CardsClient cardsClient;
    private final RequestCardPublisher requestCardPublisher;

    public CustomerSituation getCustomerSituation(String cpf) throws CustomerDataNotFoundException,
            CustomerServiceException {
        try {
            var customer = customerClient.findCustomer(cpf);
            var cards = cardsClient.getCardsByCustomer(cpf);

            var situation = new CustomerSituation();
            situation.setCustomer(customer);
            situation.setCards(cards);

            return situation;
        } catch (FeignException e) {
            var status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException();
            }
            throw new CustomerServiceException(e.getMessage(), e.status());
        }
    }

    public CustomerRatingResponse generateRating(String cpf, Long income)
            throws CustomerDataNotFoundException, CustomerServiceException {
        try {
            var customerResponse = customerClient.findCustomer(cpf);
            var cardsResponse = cardsClient.indIncomeLessThanEqual(income);

            var cardsApproved = cardsResponse.stream()
                    .map(card -> convertToApprovedCard(card, customerResponse))
                    .toList();

            return new CustomerRatingResponse(cardsApproved);

        } catch (FeignException e) {
            var status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new CustomerDataNotFoundException();
            }
            throw new CustomerServiceException(e.getMessage(), e.status());
        }
    }

    private BigDecimal calculateApprovedLimit(BigDecimal basicLimit, LocalDate birthDate) {
        var currentDate = LocalDate.now();
        var age = Period.between(birthDate, currentDate).getYears();
        var factor = BigDecimal.valueOf(age).divide(BigDecimal.TEN, 2, RoundingMode.HALF_UP);
        return factor.multiply(basicLimit);
    }

    private ApprovedCard convertToApprovedCard(CustomerCard card, CustomerData customer) {
        var approvedLimit = calculateApprovedLimit(card.getLimit(), customer.getDateBirth());

        var approved = new ApprovedCard();
        approved.setCard(card.getName());
        approved.setBrand(card.getBrand());
        approved.setApprovedLimit(approvedLimit);
        return approved;
    }

    public Object requestCardIssue(RequestCardData data) {
        try {
            requestCardPublisher.requestCard(data);
            var protocol = UUID.randomUUID().toString();
            return new RequestCardProtocol(protocol);
        } catch (Exception e) {
            throw new RequestCardException(e.getMessage());
        }
    }
}