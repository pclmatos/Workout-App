package com.example.workout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.workout.data.dao.UserDAO;
import com.example.workout.common.exception.users.UserExists;
import com.example.workout.common.exception.users.UserNotFound;
import com.example.workout.common.utils.Gender;
import com.example.workout.data.dto.users.CreateOrUpdateUserDTO;
import com.example.workout.repository.UserRepository;
import com.example.workout.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserDAO> registerUser(CreateOrUpdateUserDTO dto) {
        // Check if user already exists with the given username
        UserDAO dao = getUser(dto.getUsername());

        if (dao != null) {
            throw new UserExists(dto.getUsername());
        }

        // Save user to database and return the created user
        dao = userRepository
                .save(new UserDAO(0, dto.getFirstName(), dto.getLastName(), dto.getUsername(), dto.getPassword(),
                        dto.getEmail(), dto.getAge(), dto.getWeight(), dto.getHeight(),
                        Gender.valueOf(Integer.toString(dto.getGender()))));
        return new ResponseEntity<>(dao, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDAO> getUserByUsername(String username) {
        return new ResponseEntity<UserDAO>(getUser(username), HttpStatus.FOUND);
    }

    @Override
    public ResponseEntity<UserDAO> updateUser(CreateOrUpdateUserDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    private UserDAO getUser(String username) {
        UserDAO user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFound(username));

        return user;
    }

}
