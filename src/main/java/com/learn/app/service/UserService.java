package com.learn.app.service;

import com.learn.app.model.User;

public interface UserService {

    User createUser(User user);
    User getUser(String userId);
}
