package com.example.workout.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.data.dao.ExerciseDAO;
import com.example.workout.data.dto.exercises.AddExerciseDTO;
import com.example.workout.data.dto.exercises.UpdateExerciseDTO;
import com.example.workout.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController implements ExerciseService {

    @Autowired
    private ExerciseService service;

    @Override
    public ResponseEntity<List<ExerciseDAO>> getAll() {
        return service.getAll();
    }

    @Override
    public ResponseEntity<ExerciseDAO> addExercise(AddExerciseDTO dto) {
        return service.addExercise(dto);
    }

    @Override
    public ResponseEntity<ExerciseDAO> findByName(String name) {
        return service.findByName(name);
    }

    @Override
    public ResponseEntity<ExerciseDAO> updateExercise(String name, UpdateExerciseDTO dto) {
        return service.updateExercise(name, dto);
    }

    @Override
    public ResponseEntity<Set<ExerciseDAO>> searchExercises(String type, String bodyPart, String name) {
        return service.searchExercises(type, bodyPart, name);
    }

}
