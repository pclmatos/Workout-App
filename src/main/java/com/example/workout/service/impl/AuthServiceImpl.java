package com.example.workout.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.workout.model.User;
import com.example.workout.repository.UserRepository;
import com.example.workout.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> signin(Authentication auth) {
        logger.info("Processing login request for user: {}", auth.getName());
        Optional<User> user = userRepository.findByUsername(auth.getName());

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + auth.getName());
        }

        return new ResponseEntity<>("Hello, " + user.get().getUsername() + "! Logged in successfully.", HttpStatus.OK);
    }

}
