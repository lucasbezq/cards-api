package com.github.lucasbezq.ms_credit_rating.domain.exception;

import lombok.Getter;

@Getter
public class CustomerServiceException extends Exception {

    private Integer status;

    public CustomerServiceException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
