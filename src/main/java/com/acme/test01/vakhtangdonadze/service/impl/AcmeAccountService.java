package com.acme.test01.vakhtangdonadze.service.impl;

import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import com.acme.test01.vakhtangdonadze.service.AccountService;

public class AcmeAccountService implements AccountService {
    @Override
    public void openSavingsAccount(Long accountId, Long amountToDeposit) {

    }

    @Override
    public void openCurrentAccount(Long accountId) {

    }

    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {

    }

    @Override
    public void deposit(Long accountId, int amountToDeposit) throws AccountNotFoundException {

    }
}
