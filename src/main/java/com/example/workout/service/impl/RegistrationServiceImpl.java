package com.example.workout.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.workout.common.exception.users.UserExists;
import com.example.workout.model.Gender;
import com.example.workout.model.Role;
import com.example.workout.model.User;
import com.example.workout.model.dto.users.RegisterDto;
import com.example.workout.repository.GenderRepository;
import com.example.workout.repository.RoleRepository;
import com.example.workout.repository.UserRepository;
import com.example.workout.service.RegistrationService;

import java.util.Optional;
import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public ResponseEntity<String> signup(RegisterDto dto) {
        logger.info("DTO: {}", dto);
        logger.info("Attempting to register user: {}", dto.getUsername());
        Optional<User> user = userRepository.findByUsername(dto.getUsername());
        if (user.isPresent()) {
            throw new UserExists(dto.getUsername());
        }

        userRepository.save(new User(null, dto.getUsername(),
                encoder.encode(dto.getPassword()), dto.getEmail(),
                dto.getName(), dto.getSurname(), dto.getAge(), dto.getWeight(),
                dto.getHeight(),
                genderRepository.findById(dto.getGender()).orElseThrow(
                        () -> new IllegalArgumentException("Invalid gender!")),
                roleRepository.findByName("FREE_USER"),
                Collections.emptyList()));

        return new ResponseEntity<String>("Registration successful.", HttpStatus.OK);
    }

}
