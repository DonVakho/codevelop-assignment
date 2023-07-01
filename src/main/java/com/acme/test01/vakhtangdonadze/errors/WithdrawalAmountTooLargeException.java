package com.acme.test01.vakhtangdonadze.errors;

public class WithdrawalAmountTooLargeException extends Exception {
    public WithdrawalAmountTooLargeException(long amount, String accountId) {
        super(String.format(
                "Cannot withdraw amount: %d from account with id: %s. Insufficient funds",
                amount, accountId
        ));
    }
}
