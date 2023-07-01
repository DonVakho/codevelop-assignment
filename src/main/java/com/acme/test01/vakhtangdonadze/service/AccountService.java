package com.acme.test01.vakhtangdonadze.service;

import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

public interface AccountService {
    void openSavingsAccount(Long accountId, Long amountToDeposit);

    void openCurrentAccount(Long accountId);

    void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException;

    void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException;
}
