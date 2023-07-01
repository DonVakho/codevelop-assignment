package com.acme.test01.vakhtangdonadze;

import com.acme.test01.vakhtangdonadze.customer.SimpleCustomer;

public class MyApplication {
    public static void main(String[] args) {
        SimpleCustomer customer = new SimpleCustomer("1");
        customer.getAccountService().openCurrentAccount();
        customer.getAccountService().openSavingsAccount(2000);
    }
}

