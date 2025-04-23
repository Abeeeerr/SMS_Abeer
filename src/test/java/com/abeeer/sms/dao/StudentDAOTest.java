package com.abeeer.sms.dao;

import com.abeeer.sms.model.Student;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAOImpl();
    }

    @Test
    void testAddAndGetStudentById() {
        Student student = new Student(0, "Test Student", "test@example.com", "10", "A", null, "123 Main St", 1);
        studentDAO.addStudent(student);

        List<Student> allStudents = studentDAO.getAllStudents();
        Student added = allStudents.stream()
                .filter(s -> s.getEmail().equals("test@example.com"))
                .findFirst()
                .orElse(null);

        assertNotNull(added);
        assertEquals("Test Student", added.getName());
    }

    @Test
    void testGetAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        assertNotNull(students);
        assertTrue(students.size() >= 0);
    }

    @Test
    void testUpdateStudent() {
        Student student = new Student(0, "Old Name", "update@example.com", "9", "B", null, "Address", 1);
        studentDAO.addStudent(student);

        Student added = studentDAO.getAllStudents().stream()
                .filter(s -> s.getEmail().equals("update@example.com"))
                .findFirst()
                .orElse(null);

        assertNotNull(added);
        added.setName("Updated Name");
        studentDAO.updateStudent(added);

        Student updated = studentDAO.getStudentById(added.getId());
        assertEquals("Updated Name", updated.getName());
    }

    @Test
    void testDeleteStudent() {
        Student student = new Student(0, "Delete Me", "delete@example.com", "8", "C", null, "Nowhere", 1);
        studentDAO.addStudent(student);

        Student toDelete = studentDAO.getAllStudents().stream()
                .filter(s -> s.getEmail().equals("delete@example.com"))
                .findFirst()
                .orElse(null);

        assertNotNull(toDelete);
        studentDAO.deleteStudentById(toDelete.getId());

        Student deleted = studentDAO.getStudentById(toDelete.getId());
        assertNull(deleted);
    }
}
