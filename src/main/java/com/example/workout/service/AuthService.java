package com.example.workout.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Authentication auth);

}
