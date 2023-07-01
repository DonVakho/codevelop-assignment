package com.acme.test01.vakhtangdonadze;

import com.acme.test01.vakhtangdonadze.account.Account;
import com.acme.test01.vakhtangdonadze.account.impl.CurrentAccount;
import com.acme.test01.vakhtangdonadze.account.impl.SavingsAccount;
import com.acme.test01.vakhtangdonadze.errors.AccountNotFoundException;
import com.acme.test01.vakhtangdonadze.errors.InitialDepositAmountNotEnoughException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class SystemDB {
    private static final Logger logger = LoggerFactory.getLogger(SystemDB.class);

    private SystemDB instance;

    private final Map<String, Account> accountStorage;

    private SystemDB() {
        try {
            accountStorage = initiateStorage();
        } catch (InitialDepositAmountNotEnoughException e) {
            logger.error("Database initialization failed due to exception: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private Map<String, Account> initiateStorage() throws InitialDepositAmountNotEnoughException {
        return Map.of(
                "1", new SavingsAccount(2000, "1"),
                "2", new SavingsAccount(5000, "2"),
                "3", new CurrentAccount(1000, 10000, "3"),
                "4", new CurrentAccount(-5000, 20000, "4")
        );
    }

    public Account getAccountByUserId(String userId) {
        if (accountStorage.containsKey(userId)) {
            return accountStorage.get(userId);
        } else {
            throw new AccountNotFoundException(
                    String.format("Account with associated user id of %s is not found in database", userId)
            );
        }
    }

    public SystemDB getInstance() {
        if(instance == null){
            instance =  new SystemDB();
        }
        return instance;
    }
}
