package com.abeeer.sms.service;

import com.abeeer.sms.dao.StudentDAO;
import com.abeeer.sms.dao.StudentDAOImpl;
import com.abeeer.sms.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> fetchAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudentById(id);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
}
