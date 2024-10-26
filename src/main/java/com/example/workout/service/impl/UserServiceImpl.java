package com.example.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.workout.common.exception.users.UserNotFound;
import com.example.workout.model.User;
import com.example.workout.model.dto.users.RegisterDto;
import com.example.workout.repository.UserRepository;
import com.example.workout.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<User> getUserByUsername(String username) {
        // Return the user if found
        return new ResponseEntity<User>(getByUsername(username), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<User> updateUser(RegisterDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    private User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFound(username));
    }

}
