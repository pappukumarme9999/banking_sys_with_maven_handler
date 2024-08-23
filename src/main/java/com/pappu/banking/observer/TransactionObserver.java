package com.pappu.banking.observer;

import com.pappu.banking.model.Account;

public class TransactionObserver implements AccountObserver {
    @Override
    public void update(Account account) {
        System.out.println("Transaction on account " + account.getAccountNumber() + " updated. New balance: " + account.getBalance());
    }
}
