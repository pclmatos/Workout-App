package com.example.workout.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workout.data.dao.UserDAO;
import com.example.workout.data.dto.users.CreateOrUpdateUserDTO;

public interface UserService {

    @PostMapping("/create")
    ResponseEntity<UserDAO> registerUser(@RequestBody CreateOrUpdateUserDTO dto);

    @GetMapping("/{username}")
    ResponseEntity<UserDAO> getUserByUsername(@PathVariable String username);

    @PutMapping("/update")
    ResponseEntity<UserDAO> updateUser(@RequestBody CreateOrUpdateUserDTO dto);

}