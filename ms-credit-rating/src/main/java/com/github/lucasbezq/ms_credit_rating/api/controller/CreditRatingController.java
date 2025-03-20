package com.github.lucasbezq.ms_credit_rating.api.controller;

import com.github.lucasbezq.ms_credit_rating.domain.exception.CustomerDataNotFoundException;
import com.github.lucasbezq.ms_credit_rating.domain.exception.CustomerServiceException;
import com.github.lucasbezq.ms_credit_rating.domain.exception.RequestCardException;
import com.github.lucasbezq.ms_credit_rating.domain.model.CustomerRatingData;
import com.github.lucasbezq.ms_credit_rating.domain.model.CustomerRatingResponse;
import com.github.lucasbezq.ms_credit_rating.domain.model.CustomerSituation;
import com.github.lucasbezq.ms_credit_rating.domain.model.RequestCardData;
import com.github.lucasbezq.ms_credit_rating.domain.service.CreditRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-ratings")
@RequiredArgsConstructor
public class CreditRatingController {

    private final CreditRatingService service;

    @GetMapping
    public String ping() {
        return "pong";
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<CustomerSituation> getCustomerSituation(@RequestParam("cpf") String cpf) {
        try {
            return ResponseEntity.ok(service.getCustomerSituation(cpf));
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CustomerServiceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerRatingResponse> generateRating(@RequestBody CustomerRatingData data) {
        try {
            return ResponseEntity.ok(service.generateRating(data.getCpf(), data.getIncome()));
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CustomerServiceException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).build();
        }
    }

    @PostMapping("/request-cards")
    public ResponseEntity requestCard(@RequestBody RequestCardData data) {
        try {
            var protocol = service.requestCardIssue(data);
            return ResponseEntity.ok(protocol);
        } catch (RequestCardException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
