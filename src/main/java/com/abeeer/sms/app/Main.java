package com.abeeer.sms.app;

import com.abeeer.sms.view.AdminDashboard;
import com.abeeer.sms.view.TeacherDashboard;
import com.abeeer.sms.view.StudentDashboard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Select Role to Access Dashboard ===");
        System.out.println("1. Admin");
        System.out.println("2. Teacher");
        System.out.println("3. Student");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> new AdminDashboard(1).start();
            case 2 -> new TeacherDashboard(2).start();
            case 3 -> new StudentDashboard(3).start();
            default -> System.out.println("Invalid choice. Exiting.");
        }
    }
}
