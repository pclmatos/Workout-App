package com.example.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.service.AuthService;

@RestController
public class AuthController implements AuthService {

    @Autowired
    private AuthService authService;

    @Override
    public ResponseEntity<String> signin(Authentication auth) {
        return authService.signin(auth);
    }

}
