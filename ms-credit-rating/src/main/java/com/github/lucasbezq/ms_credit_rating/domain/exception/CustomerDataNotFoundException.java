package com.github.lucasbezq.ms_credit_rating.domain.exception;

public class CustomerDataNotFoundException extends Exception {
    public CustomerDataNotFoundException() {
        super("Customer data not found for the CPF informed.");
    }
}
