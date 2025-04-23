package com.abeeer.sms.model;

/**
 * Represents a system user with login credentials and role.
 */

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String role;

    // Constructor with userId (used when fetching from DB)
    public User(int userId, String username, String password, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    // Constructor without userId (used when inserting new user)
    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
