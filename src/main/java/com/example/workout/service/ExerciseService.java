package com.example.workout.service;

import java.util.Set;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workout.model.Exercise;
import com.example.workout.model.dto.exercises.AddExerciseDto;
import com.example.workout.model.dto.exercises.ExerciseDto;
import com.example.workout.model.dto.exercises.UpdateExerciseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.websocket.server.PathParam;

public interface ExerciseService {

        @GetMapping("")
        @Operation(summary = "Get all exercises")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "A list with all exercises"),
                        @ApiResponse(responseCode = "404", description = "No exercises found")
        })
        ResponseEntity<List<ExerciseDto>> getAll();

        @PostMapping("")
        @Operation(summary = "Add a new exercise")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Exercise created successfully"),
                        @ApiResponse(responseCode = "409", description = "Exercise already exists")
        })
        ResponseEntity<ExerciseDto> addExercise(@RequestBody AddExerciseDto dto);

        @GetMapping("/{name}")
        @Operation(summary = "Get exercise by name")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Exercise found"),
                        @ApiResponse(responseCode = "404", description = "Exercise not found")
        })
        ResponseEntity<Exercise> findByName(@PathVariable String name);

        @PutMapping("/{name}")
        @Operation(summary = "Update exercise by name")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Exercise updated"),
                        @ApiResponse(responseCode = "404", description = "Exercise not found")
        })
        ResponseEntity<Exercise> updateExercise(@PathVariable String name, @RequestBody UpdateExerciseDto dto);

        @GetMapping("/search")
        @Operation(summary = "Search exercises by name, type, and body part")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Exercises found"),
                        @ApiResponse(responseCode = "404", description = "No exercises found matching the search criteria")
        })
        ResponseEntity<List<Exercise>> searchExercises(@PathParam(value = "name") String name,
                        @PathParam(value = "type") String type,
                        @PathParam(value = "bodyPart") String bodyPart);

}
