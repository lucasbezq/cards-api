package com.github.lucasbezq.ms_credit_rating.infra.feign;

import com.github.lucasbezq.ms_credit_rating.domain.model.CustomerCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "ms-cards", path = "/cards")
public interface CardsClient {

    @GetMapping
    public List<CustomerCard> getCardsByCustomer(@RequestParam("cpf") String cpf);

    @GetMapping
    public List<CustomerCard> indIncomeLessThanEqual(@RequestParam("income") Long income);

}
