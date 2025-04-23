package com.abeeer.sms.dao;

import com.abeeer.sms.model.Student;
import com.abeeer.sms.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("grade"),
                        rs.getString("section"),
                        rs.getDate("dateOfBirth"),
                        rs.getString("address"),
                        rs.getInt("parentID")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO students (name, email, grade, section, dateOfBirth, address, parentID) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getGrade());
            stmt.setString(4, student.getSection());
            stmt.setDate(5, student.getDateOfBirth());
            stmt.setString(6, student.getAddress());
            stmt.setInt(7, student.getParentID());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(Student student) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE students SET name = ?, email = ?, grade = ?, section = ?, dateOfBirth = ?, address = ?, parentID = ? WHERE id = ?")) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getGrade());
            stmt.setString(4, student.getSection());
            stmt.setDate(5, student.getDateOfBirth());
            stmt.setString(6, student.getAddress());
            stmt.setInt(7, student.getParentID());
            stmt.setInt(8, student.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(int id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(int id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("grade"),
                        rs.getString("section"),
                        rs.getDate("dateOfBirth"),
                        rs.getString("address"),
                        rs.getInt("parentID")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
