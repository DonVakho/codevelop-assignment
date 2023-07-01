package com.acme.test01.vakhtangdonadze.account.actions.withdraw;

import com.acme.test01.vakhtangdonadze.errors.WithdrawalAmountTooLargeException;

public interface WithdrawAction {
    void withdraw(int amountToWithdraw) throws WithdrawalAmountTooLargeException;
}
