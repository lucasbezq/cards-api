package com.github.lucasbezq.ms_customer.api.dto;

import java.time.LocalDate;

public record CustomerDTO(Long id,
                          String cpf,
                          String name,
                          LocalDate dateBirth) {
}
