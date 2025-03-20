package com.github.lucasbezq.ms_cards.api.dto;

import com.github.lucasbezq.ms_cards.domain.model.Brand;

import java.math.BigDecimal;

public record CardSaveRequest(String name,
                              Brand brand,
                              BigDecimal income,
                              BigDecimal limit) {}
