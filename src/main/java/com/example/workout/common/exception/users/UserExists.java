package com.example.workout.common.exception.users;

public class UserExists extends RuntimeException {

    public UserExists(String username) {
        super(String.format("User with username %s already exists", username));
    }

}
