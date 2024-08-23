package com.pappu.banking.controller;

import com.pappu.banking.model.Account;
import com.pappu.banking.service.BankingService;
public class BankingController {
    private BankingService bankingService;

    public BankingController() {
        bankingService = new BankingService();
    }

    public void showAccountDetails(String accountNumber) {
        Account account = bankingService.getAccountDetails(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transferFunds(String fromAccount, String toAccount, double amount) {
        bankingService.transferFunds(fromAccount, toAccount, amount);
        System.out.println("Transfer completed.");
    }
}
