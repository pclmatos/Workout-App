package com.example.workout.common.exception.users;

public class UserNotFound extends RuntimeException {

    public UserNotFound(String username) {
        super(String.format("User with username %s not found", username));
    }

}
