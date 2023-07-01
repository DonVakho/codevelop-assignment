package com.acme.test01.vakhtangdonadze.account.actions.withdraw.impl;

import com.acme.test01.vakhtangdonadze.account.actions.withdraw.WithdrawAction;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WithdrawCurrentAction implements WithdrawAction {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawCurrentAction.class);

    private final Supplier<Integer> getBalance;

    private final Supplier<Integer> getOverdraftLiit;

    private final Consumer<Integer> setBalance;

    private final String accountId;

    public WithdrawCurrentAction(Supplier<Integer> getBalance,
                                 Supplier<Integer> getOverdraftLiit,
                                 Consumer<Integer> setBalance,
                                 String accountId) {
        this.getBalance = getBalance;
        this.getOverdraftLiit = getOverdraftLiit;
        this.setBalance = setBalance;
        this.accountId = accountId;
    }

    @Override
    public void withdraw(int amountToWithdraw) throws WithdrawalAmountTooLargeException {
        int currentBalance = getBalance.get();
        int overdraftLimit = getOverdraftLiit.get();
        int balanceAfterWithdraw = currentBalance - amountToWithdraw;
        if(balanceAfterWithdraw < overdraftLimit){
            throw  new WithdrawalAmountTooLargeException(amountToWithdraw, accountId);
        }
        setBalance.accept(balanceAfterWithdraw);
        logger.info("Successfully withdrawn amount: {} from account with ID: {}", amountToWithdraw, accountId);
    }
}
