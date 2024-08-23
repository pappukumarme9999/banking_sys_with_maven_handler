package com.pappu.banking.service;

import com.pappu.banking.dao.AccountDAO;
import com.pappu.banking.model.Account;
import com.pappu.banking.observer.AccountObserver;
import com.pappu.banking.observer.TransactionObserver;

import java.util.ArrayList;
import java.util.List;

public class BankingService {
    private AccountDAO accountDAO;
    private List<AccountObserver> observers;

    public BankingService() {
        accountDAO = new AccountDAO();
        observers = new ArrayList<>();
        observers.add(new TransactionObserver());
    }

    public Account getAccountDetails(String accountNumber) {
        return accountDAO.getAccountByNumber(accountNumber);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accountDAO.getAccountByNumber(fromAccountNumber);
        Account toAccount = accountDAO.getAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            accountDAO.saveAccount(fromAccount);
            accountDAO.saveAccount(toAccount);

            notifyObservers(fromAccount);
            notifyObservers(toAccount);
        }
    }

    private void notifyObservers(Account account) {
        for (AccountObserver observer : observers) {
            observer.update(account);
        }
    }
}
