package com.learn.app.controller;

import com.learn.app.model.User;
import com.learn.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for entrypoint
 * */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Uses to create new user
     * @param user New user info to create user record
     * */
    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return ResponseEntity.ok(userService.createUser(user));
    }

    /**
     * Uses to retrieve user record
     * @param userId user id whose user details want to extract
     * */
    @GetMapping("user/{userId}")
    public ResponseEntity<User> userDetails(@PathVariable("userId")String userId) {

        return ResponseEntity.ok(userService.getUser(userId));
    }
}
