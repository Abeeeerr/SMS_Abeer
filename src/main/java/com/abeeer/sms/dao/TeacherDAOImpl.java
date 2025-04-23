package com.abeeer.sms.dao;

import com.abeeer.sms.model.Teacher;
import com.abeeer.sms.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM teachers");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                teachers.add(new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact"),
                        rs.getString("qualification"),
                        rs.getDate("joinDate"),
                        Teacher.parseSubjectsFromCSV(rs.getString("subjects"))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public void addTeacher(Teacher t) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO teachers (name, email, contact, qualification, joinDate, subjects) VALUES (?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, t.getName());
            stmt.setString(2, t.getEmail());
            stmt.setString(3, t.getContact());
            stmt.setString(4, t.getQualification());
            stmt.setDate(5, t.getJoinDate());
            stmt.setString(6, t.getSubjectsAsCSV());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeacher(Teacher t) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE teachers SET name = ?, email = ?, contact = ?, qualification = ?, joinDate = ?, subjects = ? WHERE id = ?")) {

            stmt.setString(1, t.getName());
            stmt.setString(2, t.getEmail());
            stmt.setString(3, t.getContact());
            stmt.setString(4, t.getQualification());
            stmt.setDate(5, t.getJoinDate());
            stmt.setString(6, t.getSubjectsAsCSV());
            stmt.setInt(7, t.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacherById(int id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM teachers WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM teachers WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contact"),
                        rs.getString("qualification"),
                        rs.getDate("joinDate"),
                        Teacher.parseSubjectsFromCSV(rs.getString("subjects"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
