package com.abeeer.sms.dao;

import com.abeeer.sms.model.User;

import java.sql.SQLException;

/**
 * Interface for user-related database operations.
 */

public interface UserDAO {
    void addUser(User user) throws SQLException;
    User authenticate(String username, String password) throws SQLException;
}
