package com.example.workout.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.workout.model.dto.users.RegisterDto;

public interface RegistrationService {

    @PostMapping("")
    ResponseEntity<String> signup(RegisterDto dto);

}
