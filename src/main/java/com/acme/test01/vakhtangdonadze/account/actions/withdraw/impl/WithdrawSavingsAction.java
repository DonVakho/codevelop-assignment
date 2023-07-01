package com.acme.test01.vakhtangdonadze.account.actions.withdraw.impl;

import com.acme.test01.vakhtangdonadze.account.actions.withdraw.WithdrawAction;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WithdrawSavingsAction implements WithdrawAction {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawSavingsAction.class);

    private static final long BALANCE_LIMIT = 1000;

    private final Supplier<Integer> getBalance;

    private final Consumer<Integer> setBalance;

    private final String accountId;

    public WithdrawSavingsAction(Supplier<Integer> getBalance, Consumer<Integer> setBalance, String accountId) {
        this.getBalance = getBalance;
        this.setBalance = setBalance;
        this.accountId = accountId;
    }

    @Override
    public void withdraw(int amountToWithdraw) throws WithdrawalAmountTooLargeException {
        int currentBalance = getBalance.get();
        int balanceAfterWithdraw = currentBalance - amountToWithdraw;
        if (balanceAfterWithdraw < BALANCE_LIMIT) {
            throw new WithdrawalAmountTooLargeException(amountToWithdraw, accountId);
        }
        setBalance.accept(balanceAfterWithdraw);
        logger.info("Successfully withdrawn amount: {} from account with ID: {}", amountToWithdraw, accountId);
    }
}
