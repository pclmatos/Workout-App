package com.example.workout.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.workout.model.dto.users.RegisterDto;
import com.example.workout.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/signup")
public class RegistrationController implements RegistrationService {

    @Autowired
    private RegistrationService registrationService;

    @Override
    public ResponseEntity<String> signup(RegisterDto dto) {
        return registrationService.signup(dto);
    }

}
