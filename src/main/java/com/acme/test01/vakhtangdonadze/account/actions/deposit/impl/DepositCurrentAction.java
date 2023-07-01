package com.acme.test01.vakhtangdonadze.account.actions.deposit.impl;

import com.acme.test01.vakhtangdonadze.account.actions.deposit.DepositAction;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DepositCurrentAction implements DepositAction {

    private static final Logger logger = LoggerFactory.getLogger(DepositCurrentAction.class);

    private final Consumer<Integer> setBalance;

    private final Supplier<Integer> getBalance;

    private final String accountId;

    public DepositCurrentAction(Supplier<Integer> getBalance, Consumer<Integer> setBalance, String accountId) {
        this.setBalance = setBalance;
        this.getBalance = getBalance;
        this.accountId = accountId;
    }

    @Override
    public void deposit(int amountToDeposit) throws AccountNotFoundException {
        int currentBalance = getBalance.get();
        setBalance.accept(currentBalance + amountToDeposit);
        logger.info("Successfully Deposited amount: {} to account with ID: {}", amountToDeposit, accountId);
    }
}
