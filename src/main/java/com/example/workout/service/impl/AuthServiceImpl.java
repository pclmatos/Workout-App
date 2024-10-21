package com.example.workout.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.workout.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public ResponseEntity<String> login(Authentication auth) {
        return null;
    }

}
