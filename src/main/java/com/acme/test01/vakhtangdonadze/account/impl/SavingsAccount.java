package com.acme.test01.vakhtangdonadze.account.impl;

import com.acme.test01.vakhtangdonadze.account.Account;
import com.acme.test01.vakhtangdonadze.account.actions.deposit.DepositAction;
import com.acme.test01.vakhtangdonadze.account.actions.deposit.impl.DepositSavingsAction;
import com.acme.test01.vakhtangdonadze.account.actions.withdraw.WithdrawAction;
import com.acme.test01.vakhtangdonadze.account.actions.withdraw.impl.WithdrawSavingsAction;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.InitialDepositAmountNotEnoughException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

import java.util.Objects;
import java.util.UUID;

public class SavingsAccount implements Account {

    private final String id = UUID.randomUUID().toString();

    private final String ownerId;

    private final WithdrawAction withdrawAction;

    private final DepositAction depositAction;

    private int balance;

    public SavingsAccount(int balance, String ownerId) throws InitialDepositAmountNotEnoughException {
        if(balance < 1000){
            throw new InitialDepositAmountNotEnoughException(ownerId, balance);
        }
        this.balance = balance;
        this.ownerId = ownerId;
        this.withdrawAction = new WithdrawSavingsAction(this::getBalance, this::setBalance, id);
        this.depositAction = new DepositSavingsAction(this::setBalance, id);
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

    public String getOwnerId() {
        return ownerId;
    }

    private int getBalance() {
        return balance;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
