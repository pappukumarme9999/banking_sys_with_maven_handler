package com.pappu.banking.factory;

import com.pappu.banking.model.Account;
import com.pappu.banking.model.CheckingAccount;
import com.pappu.banking.model.SavingsAccount;

public class AccountFactory {
    public static Account createAccount(String type, String accountNumber, String accountHolder, double balance) {
        switch (type.toLowerCase()) {
            case "savings":
                return new SavingsAccount(accountNumber, accountHolder, balance, 0.05); // 0.05 as a default interest rate
            case "checking":
                return new CheckingAccount(accountNumber, accountHolder, balance, 500.00); // 500.00 as a default overdraft limit
            default:
                throw new IllegalArgumentException("Unknown account type: " + type);
        }
    }
}
