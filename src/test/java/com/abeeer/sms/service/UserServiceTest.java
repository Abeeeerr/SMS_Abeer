package com.abeeer.sms.service;

import com.abeeer.sms.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(); // Uses real DAO/DB
    }

    @Test
    void testValidLogin() {
        User user = userService.authenticate("abeer", "12345");
        assertNotNull(user, "✅ Login should succeed with correct credentials");
        assertEquals("abeer", user.getUsername());
        assertEquals("admin", user.getRole());
    }

    @Test
    void testInvalidPassword() {
        User user = userService.authenticate("abeer", "wrongpassword");
        assertNull(user, "Login should fail with incorrect password");
    }

    @Test
    void testNonExistentUser() {
        User user = userService.authenticate("nouser", "12345");
        assertNull(user, "Login should fail for non-existent user");
    }
}
