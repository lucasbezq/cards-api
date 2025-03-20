package com.github.lucasbezq.ms_customer.domain.service;

import com.github.lucasbezq.ms_customer.domain.exception.CustomerNotFoundException;
import com.github.lucasbezq.ms_customer.domain.model.Customer;
import com.github.lucasbezq.ms_customer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void save(Customer customer) {
        repository.save(customer);
    }

    public Customer findByCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(CustomerNotFoundException::new);
    }

}
