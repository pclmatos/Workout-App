package com.example.workout.common.exception.exercises;

public class ExerciseExists extends RuntimeException {

    public ExerciseExists(String exercise) {
        super(String.format("Exercise %s already exists", exercise));
    }

}
