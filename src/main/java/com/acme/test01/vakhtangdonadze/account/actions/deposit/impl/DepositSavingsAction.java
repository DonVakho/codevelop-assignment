package com.acme.test01.vakhtangdonadze.account.actions.deposit.impl;

import com.acme.test01.vakhtangdonadze.account.actions.deposit.DepositAction;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class DepositSavingsAction implements DepositAction {

    private static final Logger logger = LoggerFactory.getLogger(DepositSavingsAction.class);

    private final Consumer<Integer> setBalance;

    private final String accountId;

    public DepositSavingsAction(Consumer<Integer> setBalance, String accountId) {
        this.setBalance = setBalance;
        this.accountId = accountId;
    }

    @Override
    public void deposit(int amountToDeposit) throws AccountNotFoundException {
        setBalance.accept(amountToDeposit);
        logger.info("Successfully Deposited amount: {} to account with ID: {}", amountToDeposit, accountId);
    }
}
