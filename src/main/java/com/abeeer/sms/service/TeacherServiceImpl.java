package com.abeeer.sms.service;

import com.abeeer.sms.dao.TeacherDAO;
import com.abeeer.sms.dao.TeacherDAOImpl;
import com.abeeer.sms.model.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAO dao = new TeacherDAOImpl();

    @Override
    public List<Teacher> fetchAllTeachers() {
        return dao.getAllTeachers();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        dao.addTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        dao.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        dao.deleteTeacherById(id);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return dao.getTeacherById(id);
    }
}
