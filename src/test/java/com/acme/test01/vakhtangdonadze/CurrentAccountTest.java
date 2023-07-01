package com.acme.test01.vakhtangdonadze;

import com.acme.test01.vakhtangdonadze.account.Account;
import com.acme.test01.vakhtangdonadze.account.impl.CurrentAccount;
import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrentAccountTest {

    @Test
    void testWithdrawWithPositiveBalance() throws WithdrawalAmountTooLargeException {
        Account account = new CurrentAccount(5000, 20000, "3");
        account.withdraw(3000);
        assertEquals(2000, account.getBalance());

    }

    @Test
    void testWithdrawWithNegativeBalanceWithinOverdraft() throws WithdrawalAmountTooLargeException {
        Account account = new CurrentAccount(-5000, 20000, "3");
        account.withdraw(3000);
        assertEquals(-8000, account.getBalance());
    }

    @Test
    void testWithdrawNegativeBalanceMoreThanOverdraft() {
        Account account = new CurrentAccount(-5000, 20000, "3");
        assertThrows(WithdrawalAmountTooLargeException.class, () -> {
            account.withdraw(20000);
        });
    }

    @Test
    void testDepositToPositive() {
        Account account = new CurrentAccount(5000, 20000, "3");
        account.deposit(5000);
        assertEquals(10000, account.getBalance());
    }

    @Test
    void testDepositToNegative() {
        Account account = new CurrentAccount(-5000, 20000, "3");
        account.deposit(4000);
        assertEquals(-1000, account.getBalance());
    }

    @Test
    void testDepositToNegative2() {
        Account account = new CurrentAccount(-5000, 20000, "3");
        account.deposit(7000);
        assertEquals(2000, account.getBalance());
    }
}
