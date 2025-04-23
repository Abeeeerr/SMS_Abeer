package com.abeeer.sms.view;

import java.util.Scanner;

public class StudentDashboard {
    private final int userId;

    public StudentDashboard(int userId) {
        this.userId = userId;
    }

    public void start() {
        System.out.println("==== Student Dashboard (userID: " + userId + ") ====");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== STUDENT MENU ====");
            System.out.println("1. View Profile");
            System.out.println("2. View Courses");
            System.out.println("3. Logout");
            System.out.print("\nEnter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Displaying profile...");
                case 2 -> System.out.println("Showing enrolled courses...");
                case 3 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }
}
