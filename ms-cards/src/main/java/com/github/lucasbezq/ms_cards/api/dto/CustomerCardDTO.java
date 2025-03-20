package com.github.lucasbezq.ms_cards.api.dto;

import java.math.BigDecimal;

public record CustomerCardDTO(Long id,
                              String name,
                              String brand,
                              BigDecimal limit) {}
