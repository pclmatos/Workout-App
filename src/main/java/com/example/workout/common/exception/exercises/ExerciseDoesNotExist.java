package com.example.workout.common.exception.exercises;

public class ExerciseDoesNotExist extends RuntimeException {

    public ExerciseDoesNotExist(String exercise) {
        super(String.format("Exercise %s does not exist", exercise));
    }

}
