package com.acme.test01.vakhtangdonadze.account.impl;

import com.acme.test01.vakhtangdonadze.account.Account;
import com.acme.test01.vakhtangdonadze.account.actions.deposit.DepositAction;
import com.acme.test01.vakhtangdonadze.account.actions.deposit.impl.DepositCurrentAction;
import com.acme.test01.vakhtangdonadze.account.actions.withdraw.WithdrawAction;
import com.acme.test01.vakhtangdonadze.account.actions.withdraw.impl.WithdrawCurrentAction;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

import java.util.Objects;
import java.util.UUID;

public class CurrentAccount implements Account {

    private static final int DEFAULT_OVERDRAFT_LIMIT = -100000;

    private final String id = UUID.randomUUID().toString();

    private final String ownerId;

    private final WithdrawAction withdrawAction;

    private final DepositAction depositAction;

    private int balance;

    private final int overdraftLimit;

    public CurrentAccount(String ownerId) {
        this.ownerId = ownerId;
        this.withdrawAction = new WithdrawCurrentAction(
                this::getBalance,
                this::getOverdraftLimit,
                this::setBalance,
                id
        );
        this.depositAction = new DepositCurrentAction(this::getBalance, this::setBalance, id);
        this.balance = 0;
        this.overdraftLimit = DEFAULT_OVERDRAFT_LIMIT;
    }

    public CurrentAccount(int balance, int overdraftLimit, String ownerId) {
        this.ownerId = ownerId;
        this.withdrawAction = new WithdrawCurrentAction(
                this::getBalance,
                this::getOverdraftLimit,
                this::setBalance,
                id
        );
        this.depositAction = new DepositCurrentAction(this::getBalance, this::setBalance, id);
        this.balance = balance;
        this.overdraftLimit = -overdraftLimit;
    }

    @Override
    public void withdraw(int amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException {
        withdrawAction.withdraw(amountToWithdraw);
    }

    @Override
    public void deposit(int amountToDeposit) throws AccountNotFoundException {
        depositAction.deposit(amountToDeposit);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    private int getOverdraftLimit() {
        return overdraftLimit;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentAccount that = (CurrentAccount) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
