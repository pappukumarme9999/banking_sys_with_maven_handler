package com.pappu.banking.config;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.util.Properties;

public class Config {
    private static Config instance;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private Config() {

        // Load sensitive info from config.properties
        // Properties properties = new Properties();
        // try (FileInputStream fis = new FileInputStream("config.properties")) {
        //     properties.load(fis);
        //     this.dbUrl = properties.getProperty("db.url");
        //     this.dbUser = properties.getProperty("db.user");
        //     this.dbPassword = properties.getProperty("db.password");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        // Load sensitive info from environment variables
        this.dbUrl = System.getenv("DB_URL");
        this.dbUser = System.getenv("DB_USER");
        this.dbPassword = System.getenv("DB_PASSWORD");


        // Fallback to defaults if environment variables are not set
        if (dbUrl == null) dbUrl = "jdbc:mysql://localhost:3306/XE";
        if (dbUser == null) dbUser = "another default db_username";
        if (dbPassword == null) dbPassword = "password for the default db_username";
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
