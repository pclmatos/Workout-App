package com.example.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.model.User;
import com.example.workout.model.dto.users.RegisterDto;
import com.example.workout.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController implements UserService {

    // User creation endpoint
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @Override
    public ResponseEntity<User> updateUser(RegisterDto dto) {
        return userService.updateUser(dto);
    }

}
