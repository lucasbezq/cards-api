package com.github.lucasbezq.ms_customer.api.controller;

import com.github.lucasbezq.ms_customer.api.converter.CustomerConverter;
import com.github.lucasbezq.ms_customer.api.converter.CustomerDTOConverter;
import com.github.lucasbezq.ms_customer.api.dto.CustomerDTO;
import com.github.lucasbezq.ms_customer.api.dto.request.CustomerSaveRequest;
import com.github.lucasbezq.ms_customer.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService service;
    private final CustomerConverter customerConverter;
    private final CustomerDTOConverter customerDTOConverter;

    @GetMapping("/ping")
    public String status() {
        log.info("find ms-customer status...");
        return "pong";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CustomerSaveRequest request) {
        var customer = customerConverter.toDomain(request);
        service.save(customer);
        var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(customer.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping
    public CustomerDTO findCustomer(@RequestParam("cpf") String cpf) {
        var customer = service.findByCpf(cpf);
        return customerDTOConverter.toDTO(customer);
    }
}
