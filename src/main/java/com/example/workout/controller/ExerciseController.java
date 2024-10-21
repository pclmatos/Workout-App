package com.example.workout.controller;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workout.data.dao.ExerciseDao;
import com.example.workout.data.dto.exercises.AddExerciseDto;
import com.example.workout.data.dto.exercises.UpdateExerciseDto;
import com.example.workout.service.ExerciseService;

@RestController
@RequestMapping("/exercise")
public class ExerciseController implements ExerciseService {

    @Autowired
    private ExerciseService service;

    @Override
    public ResponseEntity<List<ExerciseDao>> getAll() {
        return service.getAll();
    }

    @Override
    public ResponseEntity<ExerciseDao> addExercise(AddExerciseDto dto) {
        return service.addExercise(dto);
    }

    @Override
    public ResponseEntity<ExerciseDao> findByName(String name) {
        return service.findByName(name);
    }

    @Override
    public ResponseEntity<ExerciseDao> updateExercise(String name, UpdateExerciseDto dto) {
        return service.updateExercise(name, dto);
    }

    @Override
    public ResponseEntity<Set<ExerciseDao>> searchExercises(String name, String type, String bodyPart) {
        return service.searchExercises(name, type, bodyPart);
    }

}
