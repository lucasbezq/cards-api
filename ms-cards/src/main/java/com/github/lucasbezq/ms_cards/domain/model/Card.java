package com.github.lucasbezq.ms_cards.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    private BigDecimal income;
    private BigDecimal basicLimit;


}
