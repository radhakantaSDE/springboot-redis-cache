package com.learn.app.service;

import com.learn.app.model.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Keep all user operation in this service
 * */
@Service
public class UserServiceImpl implements UserService{

    /**
     * Help to create new user record
     * We are simply returning incoming user (Proxy cache operation will pick this and insert in cache)
     * */
    @CachePut(value = "users", key = "#user.id")
    @Override
    public User createUser(User user) {
        return user;
    }

    /**
     * Help to retrieve user record as per given user-id
     * Here, we are returning a fixed object(name=Ritu) every time to confirm
     * if this method returns cached record or this dummy record
     * */
    @Cacheable(value = "users", key ="#userId")
    @Override
    public User getUser(String userId) {
        return User.builder().id("100").name("Ritu").address("BBS").build();
    }
}
