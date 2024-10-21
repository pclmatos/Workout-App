package com.example.workout.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workout.data.dao.User;
import com.example.workout.data.dto.users.RegisterDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface UserService {

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Register a new user"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    ResponseEntity<User> registerUser(@RequestBody RegisterDto dto);

    @GetMapping("/{username}")
    @Operation(summary = "Get user by username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity<User> getUserByUsername(@PathVariable String username);

    @PutMapping("/update")
    @Operation(summary = "Update user information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated user information"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity<User> updateUser(@RequestBody RegisterDto dto);

}