package com.acme.test01.vakhtangdonadze;

import com.acme.test01.vakhtangdonadze.account.Account;
import com.acme.test01.vakhtangdonadze.account.impl.SavingsAccount;
import com.acme.test01.vakhtangdonadze.errors.InitialDepositAmountNotEnoughException;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingsAccountTest {

    @Test
    void testOpenAccountWithInsufficientFunds() {
        assertThrows(InitialDepositAmountNotEnoughException.class, () -> {
            new SavingsAccount(500, "1");
        });
    }

    @Test
    void testOpenAccountWithSufficientFunds() throws InitialDepositAmountNotEnoughException {
        Account account = new SavingsAccount(5000, "1");
        assertEquals(5000, account.getBalance());
    }

    @Test
    void testWithdrawNormal() throws WithdrawalAmountTooLargeException, InitialDepositAmountNotEnoughException {
        Account account = new SavingsAccount(5000, "3");
        account.withdraw(3000);
        assertEquals(2000, account.getBalance());

    }

    @Test
    void testWithdrawIllegal() throws WithdrawalAmountTooLargeException, InitialDepositAmountNotEnoughException {
        Account account = new SavingsAccount(5000, "3");
        assertThrows(WithdrawalAmountTooLargeException.class, () -> {
            account.withdraw(4500);
        });
    }

    @Test
    void testDepositToPositive() throws InitialDepositAmountNotEnoughException {
        Account account = new SavingsAccount(5000, "3");
        account.deposit(5000);
        assertEquals(10000, account.getBalance());
    }
}
