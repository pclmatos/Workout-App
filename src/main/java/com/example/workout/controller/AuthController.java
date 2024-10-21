package com.example.workout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthService {

    @Autowired
    private AuthService authService;

    @Override
    public ResponseEntity<String> login(Authentication auth) {
        return authService.login(auth);
    }

}
