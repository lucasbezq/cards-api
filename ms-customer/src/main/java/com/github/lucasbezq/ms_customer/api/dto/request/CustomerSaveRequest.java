package com.github.lucasbezq.ms_customer.api.dto.request;

import java.time.LocalDate;

public record CustomerSaveRequest(String cpf,
                                  String name,
                                  LocalDate dateBirth) {}
