package com.abeeer.sms.service;

import com.abeeer.sms.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> fetchAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
    Student getStudentById(int id);
}
