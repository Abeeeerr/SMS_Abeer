package com.abeeer.sms.controller;

import com.abeeer.sms.model.Student;
import com.abeeer.sms.service.StudentService;
import com.abeeer.sms.service.StudentServiceImpl;

import java.util.List;

public class StudentController {
    private final StudentService studentService = new StudentServiceImpl();

    public List<Student> getAllStudents() {
        return studentService.fetchAllStudents();
    }

    public void addStudent(Student student) {
        studentService.addStudent(student);
    }

    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return studentService.getStudentById(id);
    }
}
