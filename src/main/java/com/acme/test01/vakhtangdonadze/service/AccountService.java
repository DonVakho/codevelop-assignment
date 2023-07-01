package com.acme.test01.vakhtangdonadze.service;

import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

public interface AccountService {
    void openSavingsAccount(int amountToDeposit);

    void openCurrentAccount();

    void withdraw(int amountToWithdraw)
            throws AccountNotFoundException, WithdrawalAmountTooLargeException;

    void deposit(int amountToDeposit) throws AccountNotFoundException;
}
