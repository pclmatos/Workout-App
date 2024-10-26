package com.example.workout.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.workout.common.exception.exercises.ExerciseDoesNotExist;
import com.example.workout.common.exception.exercises.ExerciseExists;
import com.example.workout.common.exception.exercises.NoExercises;

@RestControllerAdvice
public class ExerciseControllerAdvice {
    @ExceptionHandler(ExerciseDoesNotExist.class)
    public ResponseEntity<String> handleExerciseDoesNotExist(ExerciseDoesNotExist e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExerciseExists.class)
    public ResponseEntity<String> handleExerciseExists(ExerciseExists e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoExercises.class)
    public ResponseEntity<String> handleNoExercisesExist(NoExercises e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
