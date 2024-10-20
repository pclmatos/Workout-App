package com.example.workout.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.workout.common.exception.users.UserExists;
import com.example.workout.common.exception.users.UserNotFound;

@RestControllerAdvice
public class UserControllerAdvice {

    // User-related exception handling
    @ExceptionHandler(UserExists.class)
    public ResponseEntity<String> handleUserExists(UserExists e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
