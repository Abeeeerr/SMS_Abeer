package com.abeeer.sms.service;

import com.abeeer.sms.model.User;

public interface UserService {
    User authenticate(String username, String password);
}
