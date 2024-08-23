package com.pappu.banking.dao;

import com.pappu.banking.config.Config;
import com.pappu.banking.model.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    private Config config = Config.getInstance();

    public Account getAccountByNumber(String accountNumber) {
        Account account = null;
        try (Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getDbUser(), config.getDbPassword())) {
            String sql = "SELECT * FROM accounts WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                account = new Account(rs.getString("account_number"),
                        rs.getString("account_holder"),
                        rs.getDouble("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public void saveAccount(Account account) {
        try (Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getDbUser(), config.getDbPassword())) {
            String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, account.getBalance());
            stmt.setString(2, account.getAccountNumber());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
