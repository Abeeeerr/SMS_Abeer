package com.abeeer.sms.view;

import com.abeeer.sms.controller.StudentController;
import com.abeeer.sms.model.Student;
import com.abeeer.dashtable.Converter;
import com.abeeer.sms.utils.Trie;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * View class to handle all user interaction for Student management.
 */

public class StudentView {
    private final StudentController controller = new StudentController();
    private final Scanner scanner = new Scanner(System.in);
    private final Trie trie = new Trie();

    public StudentView() {
        // On startup, load all student names into the Trie
        for (Student s : controller.getAllStudents()) {
            trie.insert(s.getName());
        }
    }

    // Handles user input to add a new student
    public void handleUserFlow() {
        System.out.println("Enter Student Details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Grade: ");
        String grade = scanner.nextLine();

        System.out.print("Section: ");
        String section = scanner.nextLine();

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        Date dob = Date.valueOf(scanner.nextLine());

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Parent ID: ");
        int parentID = Integer.parseInt(scanner.nextLine());

        Student student = new Student(name, email, grade, section, dob, address, parentID);
        controller.addStudent(student);
        trie.insert(name); // Add to Trie

        System.out.println("Student added successfully!\n");
        displayStudents();
    }

    // Displays all students in a table
    public void displayStudents() {
        List<Student> students = controller.getAllStudents();

        List<String> headers = List.of("ID", "Name", "Email", "Grade", "Section", "DOB", "Address", "Parent ID");
        List<List<String>> rows = new ArrayList<>();

        for (Student s : students) {
            rows.add(List.of(
                    String.valueOf(s.getId()),
                    s.getName() != null ? s.getName() : "N/A",
                    s.getEmail() != null ? s.getEmail() : "N/A",
                    s.getGrade() != null ? s.getGrade() : "N/A",
                    s.getSection() != null ? s.getSection() : "N/A",
                    s.getDateOfBirth() != null ? s.getDateOfBirth().toString() : "N/A",
                    s.getAddress() != null ? s.getAddress() : "N/A",
                    String.valueOf(s.getParentID())
            ));
        }

        Converter converter = new Converter();
        converter.printData(rows, headers);
    }

    // Updates an existing student
    public void updateStudentFlow() {
        System.out.print("Enter Student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = controller.getStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Leave fields blank to keep current value.");

        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) student.setEmail(email);

        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        if (!grade.isEmpty()) student.setGrade(grade);

        System.out.print("Section: ");
        String section = scanner.nextLine();
        if (!section.isEmpty()) student.setSection(section);

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        String dobStr = scanner.nextLine();
        if (!dobStr.isEmpty()) student.setDateOfBirth(Date.valueOf(dobStr));

        System.out.print("Address: ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) student.setAddress(address);

        System.out.print("Parent ID: ");
        String parentStr = scanner.nextLine();
        if (!parentStr.isEmpty()) student.setParentID(Integer.parseInt(parentStr));

        controller.updateStudent(student);
        trie.insert(student.getName()); // Update Trie with new name
        System.out.println("Student updated!");
        displayStudents();
    }

    // Deletes a student
    public void deleteStudentFlow() {
        System.out.print("Enter Student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        controller.deleteStudent(id);
        System.out.println("Student deleted!");
        displayStudents();
    }

    // Search students by name prefix
    public void searchStudentByPrefix() {
        System.out.print("Enter name prefix: ");
        String prefix = scanner.nextLine();

        List<String> matches = trie.searchByPrefix(prefix);
        if (matches.isEmpty()) {
            System.out.println("No student names found for prefix: " + prefix);
        } else {
            System.out.println("Matching students:");
            matches.forEach(System.out::println);
        }
    }
}
