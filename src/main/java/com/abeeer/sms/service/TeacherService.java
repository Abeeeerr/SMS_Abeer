package com.abeeer.sms.service;

import com.abeeer.sms.model.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> fetchAllTeachers();
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int id);
    Teacher getTeacherById(int id);
}
