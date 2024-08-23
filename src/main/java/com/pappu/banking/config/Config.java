package com.pappu.banking.config;

public class Config {
    private static Config instance;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private Config() {
        // Load from environment variables or configuration file
        this.dbUrl = "jdbc:mysql://localhost:3306/banking_system_pappu";
        this.dbUser = "root";
        this.dbPassword = "password";
    }

    public static Config getInstance() {
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
