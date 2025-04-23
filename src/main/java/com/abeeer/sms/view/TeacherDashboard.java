package com.abeeer.sms.view;

import java.util.Scanner;

public class TeacherDashboard {
    private final int userId;

    public TeacherDashboard(int userId) {
        this.userId = userId;
    }

    public void start() {
        System.out.println("==== Teacher Dashboard (userID: " + userId + ") ====");
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== TEACHER MENU ====");
            System.out.println("1. View My Students");
            System.out.println("2. View My Subjects");
            System.out.println("3. Logout");
            System.out.print("\nEnter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing assigned students...");
                case 2 -> System.out.println("Viewing subjects...");
                case 3 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 3);
    }
}
