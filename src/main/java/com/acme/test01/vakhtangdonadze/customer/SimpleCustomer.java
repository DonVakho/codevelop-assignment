package com.acme.test01.vakhtangdonadze.customer;

import com.acme.test01.vakhtangdonadze.service.AccountService;
import com.acme.test01.vakhtangdonadze.service.impl.AcmeAccountService;

public class SimpleCustomer {
    private final String id;

    private final AccountService accountService;

    public SimpleCustomer(String id) {
        this.id = id;
        this.accountService = new AcmeAccountService(id);
    }

    public String getId() {
        return id;
    }

    public AccountService getAccountService() {
        return accountService;
    }
}
