package com.abeeer.sms.controller;

import com.abeeer.sms.model.Teacher;
import com.abeeer.sms.service.TeacherService;
import com.abeeer.sms.service.TeacherServiceImpl;

import java.util.List;

public class TeacherController {
    private final TeacherService service = new TeacherServiceImpl();

    public List<Teacher> getAllTeachers() {
        return service.fetchAllTeachers();
    }

    public void addTeacher(Teacher teacher) {
        service.addTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        service.updateTeacher(teacher);
    }

    public void deleteTeacher(int id) {
        service.deleteTeacher(id);
    }

    public Teacher getTeacherById(int id) {
        return service.getTeacherById(id);
    }
}
