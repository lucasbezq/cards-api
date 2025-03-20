package com.github.lucasbezq.ms_cards.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class CustomerCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private BigDecimal basicLimit;

    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;

}
