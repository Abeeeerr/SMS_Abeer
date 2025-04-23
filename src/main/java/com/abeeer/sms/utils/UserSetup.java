package com.abeeer.sms.utils;

import com.abeeer.sms.dao.UserDAO;
import com.abeeer.sms.dao.UserDAOImpl;
import com.abeeer.sms.model.User;

/**
 * Utility class to add an initial admin user
 */

public class UserSetup {
    public static void main(String[] args) {
        try {
            UserDAO dao = new UserDAOImpl();

            User user = new User(
                    0,
                    "abeer",
                    "12345",
                    "abeer@example.com",
                    "admin"
            );

            dao.addUser(user);
            System.out.println("User added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add user.");
            e.printStackTrace();
        }
    }
}
