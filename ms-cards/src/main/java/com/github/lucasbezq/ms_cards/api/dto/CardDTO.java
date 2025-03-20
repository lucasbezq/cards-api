package com.github.lucasbezq.ms_cards.api.dto;

import java.math.BigDecimal;

public record CardDTO(Long  id,
                      String name,
                      String brand,
                      BigDecimal income,
                      BigDecimal limit) {}
