package com.abeeer.sms.view;

import com.abeeer.sms.controller.TeacherController;
import com.abeeer.sms.model.Teacher;
import com.abeeer.sms.utils.Trie;
import com.abeeer.dashtable.Converter;

import java.sql.Date;
import java.util.*;

/**
 * View class to handle all user interaction for Teacher management.
 */

public class TeacherView {
    private final TeacherController controller = new TeacherController();
    private final Scanner scanner = new Scanner(System.in);
    private final Trie trie = new Trie();

    public TeacherView() {
        for (Teacher t : controller.getAllTeachers()) {
            trie.insert(t.getName());
        }
    }

    // Add new teacher
    public void handleTeacherInput() {
        System.out.println("Enter Teacher Details:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Contact: ");
        String contact = scanner.nextLine();

        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();

        System.out.print("Join Date (yyyy-mm-dd): ");
        Date joinDate = Date.valueOf(scanner.nextLine());

        System.out.print("Enter Subjects (comma-separated): ");
        String subjectCSV = scanner.nextLine();
        List<String> subjects = Arrays.asList(subjectCSV.split(","));

        Teacher teacher = new Teacher(name, email, contact, qualification, joinDate, subjects);
        controller.addTeacher(teacher);
        trie.insert(name);

        System.out.println("Teacher added successfully!");
        displayTeachers();
    }

    // Display all teachers
    public void displayTeachers() {
        List<Teacher> teachers = controller.getAllTeachers();

        List<String> headers = List.of("ID", "Name", "Email", "Contact", "Qualification", "Join Date", "Subjects");
        List<List<String>> rows = new ArrayList<>();

        for (Teacher t : teachers) {
            rows.add(List.of(
                    String.valueOf(t.getId()),
                    t.getName() != null ? t.getName() : "N/A",
                    t.getEmail() != null ? t.getEmail() : "N/A",
                    t.getContact() != null ? t.getContact() : "N/A",
                    t.getQualification() != null ? t.getQualification() : "N/A",
                    t.getJoinDate() != null ? t.getJoinDate().toString() : "N/A",
                    t.getSubjects() != null ? String.join(", ", t.getSubjects()) : "N/A"
            ));
        }

        Converter converter = new Converter();
        converter.printData(rows, headers);
    }

    // Update teacher
    public void updateTeacherFlow() {
        System.out.print("Enter Teacher ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Teacher teacher = controller.getTeacherById(id);
        if (teacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.println("Leave fields blank to keep existing values.");

        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) teacher.setName(name);

        System.out.print("Email: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) teacher.setEmail(email);

        System.out.print("Contact: ");
        String contact = scanner.nextLine();
        if (!contact.isEmpty()) teacher.setContact(contact);

        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();
        if (!qualification.isEmpty()) teacher.setQualification(qualification);

        System.out.print("Join Date (yyyy-mm-dd): ");
        String joinDateStr = scanner.nextLine();
        if (!joinDateStr.isEmpty()) teacher.setJoinDate(Date.valueOf(joinDateStr));

        System.out.print("Subjects (comma-separated): ");
        String subjects = scanner.nextLine();
        if (!subjects.isEmpty()) teacher.setSubjects(Arrays.asList(subjects.split(",")));

        controller.updateTeacher(teacher);
        trie.insert(teacher.getName());

        System.out.println("Teacher updated!");
        displayTeachers();
    }

    // Delete teacher
    public void deleteTeacherFlow() {
        System.out.print("Enter Teacher ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        controller.deleteTeacher(id);
        System.out.println("Teacher deleted!");
        displayTeachers();
    }

    // Search teacher by name prefix
    public void searchTeacherByPrefix() {
        System.out.print("Enter name prefix to search: ");
        String prefix = scanner.nextLine();

        List<String> matches = trie.searchByPrefix(prefix);
        if (matches.isEmpty()) {
            System.out.println("No teacher names found for prefix: " + prefix);
        } else {
            System.out.println("Matching teachers:");
            matches.forEach(System.out::println);
        }
    }
}
