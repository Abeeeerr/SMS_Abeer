package com.abeeer.sms.view;

import com.abeeer.sms.dao.UserDAO;
import com.abeeer.sms.dao.UserDAOImpl;
import com.abeeer.sms.model.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * View class to handle user-related actions like creating new users (admin only).
 */

public class UserView {
    private final Scanner scanner = new Scanner(System.in);
    private final UserDAO userDAO = new UserDAOImpl();

    /**
     * Allows admin to create a new user from CLI.
     */

    public void createUserFromCLI() {
        try {
            System.out.println("\n=== Add New User ===");

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter role (admin/teacher/student/parent): ");
            String role = scanner.nextLine().toLowerCase();

            User user = new User(username, password, email, role);
            userDAO.addUser(user);

            System.out.println("\nUser added successfully!");

        } catch (SQLException e) {
            System.out.println("Failed to add user.");
            e.printStackTrace();
        }
    }
}
