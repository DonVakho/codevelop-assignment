package com.acme.test01.vakhtangdonadze.errors;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
