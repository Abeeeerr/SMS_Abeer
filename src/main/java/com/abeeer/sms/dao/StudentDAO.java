package com.abeeer.sms.dao;

import com.abeeer.sms.model.Student;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int id);
    Student getStudentById(int id);
}
