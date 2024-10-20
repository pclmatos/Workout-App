package com.example.workout.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workout.data.dao.ExerciseDAO;
import com.example.workout.data.dto.exercises.AddExerciseDTO;
import com.example.workout.data.dto.exercises.UpdateExerciseDTO;

import jakarta.websocket.server.PathParam;

public interface ExerciseService {

    @GetMapping("")
    ResponseEntity<List<ExerciseDAO>> getAll();

    @PostMapping("")
    ResponseEntity<ExerciseDAO> addExercise(@RequestBody AddExerciseDTO dto);

    @GetMapping("/{name}")
    ResponseEntity<ExerciseDAO> findByName(@PathVariable String name);

    @PutMapping("/{name}")
    ResponseEntity<ExerciseDAO> updateExercise(@PathVariable String name, @RequestBody UpdateExerciseDTO dto);

    @GetMapping("/search")
    ResponseEntity<Set<ExerciseDAO>> searchExercises(@PathParam(value = "type") String type,
            @PathParam(value = "bodyPart") String bodyPart, @PathParam(value = "name") String name);

}
