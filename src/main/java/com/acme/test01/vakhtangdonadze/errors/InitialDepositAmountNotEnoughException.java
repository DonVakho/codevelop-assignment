package com.acme.test01.vakhtangdonadze.errors;

public class InitialDepositAmountNotEnoughException extends Exception{
    public InitialDepositAmountNotEnoughException(String userId, long deposit) {
        super(String.format(
                "Cannot Open Savings Account with initial deposit of '%d' for user with ID: '%s'. " +
                        "Initial deposit must be more than R1000.", deposit, userId));
    }
}
