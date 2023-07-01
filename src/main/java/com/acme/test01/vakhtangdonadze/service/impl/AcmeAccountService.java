package com.acme.test01.vakhtangdonadze.service.impl;

import com.acme.test01.vakhtangdonadze.SystemDB;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import com.acme.test01.vakhtangdonadze.service.AccountService;

public class AcmeAccountService implements AccountService {

    private final String userId;

    private SystemDB database = SystemDB.getInstance();

    public AcmeAccountService(String userId) {
        this.userId = userId;
    }

    @Override
    public void openSavingsAccount(int amountToDeposit) {
        //TODO
    }

    @Override
    public void openCurrentAccount() {
        //TODO

    }

    @Override
    public void withdraw(int amountToWithdraw)
            throws AccountNotFoundException, WithdrawalAmountTooLargeException {
        //TODO

    }

    @Override
    public void deposit(int amountToDeposit) throws AccountNotFoundException {
        //TODO
    }
}
