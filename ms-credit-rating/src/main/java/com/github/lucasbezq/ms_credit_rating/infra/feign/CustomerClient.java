package com.github.lucasbezq.ms_credit_rating.infra.feign;

import com.github.lucasbezq.ms_credit_rating.domain.model.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-customer", path = "/customers")
public interface CustomerClient {

    @GetMapping
    public CustomerData findCustomer(@RequestParam("cpf") String cpf);

}
