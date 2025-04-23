package com.abeeer.sms.dao;

import com.abeeer.sms.model.User;
import com.abeeer.sms.utils.DatabaseUtil;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles DB operations for users, including secure login using BCrypt.
 */

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO user (username, password, email, role) VALUES (?, ?, ?, ?)";
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, hashedPassword);
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());
            stmt.executeUpdate();
        }
    }

    @Override
    public User authenticate(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, hashedPassword)) {
                    return extractUser(rs);
                }
            }
        }
        return null;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("userID"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("role")
        );
    }
}
