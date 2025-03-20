package com.github.lucasbezq.ms_customer.api.converter;

import com.github.lucasbezq.ms_customer.api.dto.CustomerDTO;
import com.github.lucasbezq.ms_customer.api.dto.request.CustomerSaveRequest;
import com.github.lucasbezq.ms_customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOConverter {

    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getCpf(),
                customer.getName(),
                customer.getDateBirth()
        );
    }

}
