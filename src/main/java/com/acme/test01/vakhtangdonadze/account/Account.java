package com.acme.test01.vakhtangdonadze.account;

import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

public interface Account {
    void withdraw(int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException;

    void deposit(int amountToDeposit) throws AccountNotFoundException;

    String getId();
}
