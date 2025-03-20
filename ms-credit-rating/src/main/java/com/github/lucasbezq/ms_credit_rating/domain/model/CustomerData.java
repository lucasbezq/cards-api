package com.github.lucasbezq.ms_credit_rating.domain.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerData {

    //TODO: Change to UUID
    private Long id;
    private String name;
    private LocalDate dateBirth;
}
