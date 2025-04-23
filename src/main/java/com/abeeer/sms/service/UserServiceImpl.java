package com.abeeer.sms.service;

import com.abeeer.sms.dao.UserDAO;
import com.abeeer.sms.dao.UserDAOImpl;
import com.abeeer.sms.model.User;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    public User authenticate(String username, String password) {
        try {
            return userDAO.authenticate(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
