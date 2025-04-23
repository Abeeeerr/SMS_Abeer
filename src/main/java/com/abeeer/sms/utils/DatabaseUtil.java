package com.abeeer.sms.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Utility class to manage database connections using properties file.
 */

public class DatabaseUtil {
    private static Connection connection;

    /**
     * Handles all exceptions internally.
     * @return Connection object or null if connection fails
     */

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                InputStream input = DatabaseUtil.class.getClassLoader().getResourceAsStream("db.properties");

                if (input == null) {
                    System.err.println("db.properties file not found.");
                    return null;
                }

                props.load(input);
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        props.getProperty("url"),
                        props.getProperty("user"),
                        props.getProperty("password")
                );

            } catch (Exception e) {
                System.err.println("Database connection failed: " + e.getMessage());
                return null;
            }
        } else {
            try {
                if (connection.isClosed()) {
                    connection = null;
                    return getConnection(); // Retry connection
                }
            } catch (Exception e) {
                System.err.println("Error checking DB connection: " + e.getMessage());
                return null;
            }
        }

        return connection;
    }
}
