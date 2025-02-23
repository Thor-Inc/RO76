package com.sda.demo.controller;

import com.sda.demo.model.User;
import com.sda.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }
}
