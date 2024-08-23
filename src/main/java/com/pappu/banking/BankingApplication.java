package com.pappu.banking;

import com.pappu.banking.controller.BankingController;
import com.pappu.banking.factory.AccountFactory;
import com.pappu.banking.model.Account;

public class BankingApplication {
    public static void main(String[] args) {
        BankingController controller = new BankingController();

        // Example usage:
        Account savingsAccount = AccountFactory.createAccount("savings", "1234567890", "John Doe", 1000.0);
        controller.showAccountDetails("1234567890");
        controller.transferFunds("1234567890", "0987654321", 100.00);
    }
}