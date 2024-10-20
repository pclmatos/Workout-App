package com.example.workout.common.exception.exercises;

public class NoExercises extends RuntimeException {

    public NoExercises() {
        super("No exercises found!");
    }

    public NoExercises(String error) {
        super(error);
    }

}
