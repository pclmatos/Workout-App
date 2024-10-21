package com.example.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.workout.common.exception.users.UserExists;
import com.example.workout.common.exception.users.UserNotFound;
import com.example.workout.common.utils.Gender;
import com.example.workout.data.dao.User;
import com.example.workout.data.dto.users.RegisterDto;
import com.example.workout.repository.UserRepository;
import com.example.workout.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public ResponseEntity<User> registerUser(RegisterDto dto) {
        // Check if user already exists with the given username
        User dao;

        try {
            dao = getByUsername(dto.getUsername());

            if (dao != null) {
                throw new UserExists(dto.getUsername());
            }
        } catch (UserNotFound e) {
            dao = userRepository
                    .save(new User(dto.getUsername(), encoder.encode(dto.getPassword()), dto.getEmail(), dto.getName(),
                            dto.getSurname(), dto.getAge(),
                            dto.getWeight(),
                            dto.getHeight(), Gender.fromValue(dto.getGender()),
                            "ROLE_USER"));
        }
        return new ResponseEntity<User>(dao, HttpStatus.CREATED);
    }

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
