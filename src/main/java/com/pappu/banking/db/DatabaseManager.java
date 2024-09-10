package com.pappu.banking.db;
import com.pappu.banking.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    public static void main(String[] args) {
        // Get configuration from the Config class
        Config config = Config.getInstance();

        String dbUrl = config.getDbUrl();
        String dbUser = config.getDbUser();
        String dbPassword = config.getDbPassword();


        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {
             
            // Check if the database exists
            String sql = "CREATE DATABASE IF NOT EXISTS ";
            stmt.executeUpdate(sql);
            System.out.println("Database checked/created successfully.");
            
        } catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("Database does not exist.");
                // Optionally, create the database or notify the user
            } else {
                e.printStackTrace(); // Other SQL exceptions
            }
        }
    }
}
