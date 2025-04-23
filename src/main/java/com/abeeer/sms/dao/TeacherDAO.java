package com.abeeer.sms.dao;

import com.abeeer.sms.model.Teacher;
import java.util.List;

public interface TeacherDAO {
    List<Teacher> getAllTeachers();
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById(int id);
    Teacher getTeacherById(int id);
}
