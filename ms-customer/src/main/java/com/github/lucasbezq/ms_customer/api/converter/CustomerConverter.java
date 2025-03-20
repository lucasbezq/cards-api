package com.github.lucasbezq.ms_customer.api.converter;

import com.github.lucasbezq.ms_customer.api.dto.request.CustomerSaveRequest;
import com.github.lucasbezq.ms_customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer toDomain(CustomerSaveRequest request) {
        var customer = new Customer();
        customer.setCpf(request.cpf());
        customer.setName(request.name());
        customer.setDateBirth(request.dateBirth());
        return customer;
    }

}
