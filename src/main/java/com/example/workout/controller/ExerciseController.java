package com.example.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.model.Exercise;
import com.example.workout.model.dto.exercises.AddExerciseDto;
import com.example.workout.model.dto.exercises.ExerciseDto;
import com.example.workout.model.dto.exercises.UpdateExerciseDto;
import com.example.workout.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController implements ExerciseService {

    @Autowired
    private ExerciseService service;

    @Override
    public ResponseEntity<List<ExerciseDto>> getAll() {
        return service.getAll();
    }

    @Override
    public ResponseEntity<ExerciseDto> addExercise(AddExerciseDto dto) {
        return service.addExercise(dto);
    }

    @Override
    public ResponseEntity<Exercise> findByName(String name) {
        return service.findByName(name);
    }

    @Override
    public ResponseEntity<Exercise> updateExercise(String name, UpdateExerciseDto dto) {
        return service.updateExercise(name, dto);
    }

    @Override
    public ResponseEntity<List<Exercise>> searchExercises(String name, String type, String bodyPart) {
        return service.searchExercises(name, type, bodyPart);
    }

}
