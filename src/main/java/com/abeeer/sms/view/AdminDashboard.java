package com.abeeer.sms.view;

import java.util.Scanner;

public class AdminDashboard {
    private final Scanner scanner = new Scanner(System.in);
    private final int userId;

    public AdminDashboard(int userId) {
        this.userId = userId;
        System.out.println("Admin Dashboard (userID: " + userId + ")");
    }

    public void start() {
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();

        while (true) {
            System.out.println("""
            \n==== ADMIN MENU ====
            1. View Students
            2. Add Student
            3. Update Student
            4. Delete Student
            5. Search Student
            6. View Teachers
            7. Add Teacher
            8. Update Teacher
            9. Delete Teacher
            10. Search Teacher
            0. Logout
            """);

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> studentView.displayStudents();
                case 2 -> studentView.handleUserFlow();
                case 3 -> studentView.updateStudentFlow();
                case 4 -> studentView.deleteStudentFlow();
                case 5 -> studentView.searchStudentByPrefix();
                case 6 -> teacherView.displayTeachers();
                case 7 -> teacherView.handleTeacherInput();
                case 8 -> teacherView.updateTeacherFlow();
                case 9 -> teacherView.deleteTeacherFlow();
                case 10 -> teacherView.searchTeacherByPrefix();
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
