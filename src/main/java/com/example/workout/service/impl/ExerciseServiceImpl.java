package com.example.workout.service.impl;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.workout.common.exception.exercises.ExerciseDoesNotExist;
import com.example.workout.common.exception.exercises.ExerciseExists;
import com.example.workout.common.exception.exercises.NoExercises;
import com.example.workout.model.BodyPart;
import com.example.workout.model.Exercise;
import com.example.workout.model.ExerciseType;
import com.example.workout.model.dto.exercises.AddExerciseDto;
import com.example.workout.model.dto.exercises.ExerciseDto;
import com.example.workout.model.dto.exercises.UpdateExerciseDto;
import com.example.workout.repository.BodyPartRepository;
import com.example.workout.repository.ExerciseRepository;
import com.example.workout.repository.ExerciseTypeRepository;
import com.example.workout.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);

    @Autowired
    private ExerciseRepository exercises;

    @Autowired
    private ExerciseTypeRepository typeRepository;

    @Autowired
    private BodyPartRepository bodyPartRepository;

    @Override
    public ResponseEntity<List<ExerciseDto>> getAll() {
        List<Exercise> list = (List<Exercise>) exercises.findAll();
        if (list.isEmpty()) {
            throw new NoExercises();
        }
        return new ResponseEntity<>(list.stream().map(ExerciseDto::new).collect(Collectors.toList()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ExerciseDto> addExercise(AddExerciseDto dto) {

        Exercise exercise;
        try {
            exercise = getByName(dto.getName());
            if (exercise != null) {
                logger.error("Exercise {} already exists", dto.getName());
                throw new ExerciseExists(dto.getName());
            }

        } catch (ExerciseDoesNotExist e) {
            // logger.info("Body parts available: {}",
            // ((List<BodyPart>)
            // bodyPartRepository.findAll()).stream().map(BodyPart::getName)
            // .collect(Collectors.toList()));
            logger.info("Adding exercise {} of type {} and body part {}", dto.getName(),
                    dto.getType(),
                    dto.getBodyPart());

            exercise = new Exercise(0, dto.getName(), typeRepository.findByName(dto.getType())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid exercise type")),
                    bodyPartRepository.findByName(dto.getBodyPart())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid body part")));
        }
        return new ResponseEntity<ExerciseDto>(new ExerciseDto(
                exercises.save(exercise)),
                HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Exercise> findByName(String name) {

        Exercise Exercise = getByName(name);

        return new ResponseEntity<Exercise>(Exercise, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Exercise> updateExercise(String name, UpdateExerciseDto dto) {
        Exercise exercise = getByName(name);
        exercise.setName(dto.getName());

        return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Exercise>> searchExercises(String name, String type, String bodyPart) {
        logger.info("Searching exercises for name {}", name);
        List<Exercise> result = new LinkedList<>();
        // if (name != null) {
        // result = exercises.findByNameContaining(name);
        // } else {

        // List<Exercise> exercisesByType = type == null ? null
        // : typeRepository.getExercisesByType(type);
        // List<Exercise> body_part = bodyPart == null ? null
        // : bodyPartRepository.findByBodyPart(bodyPart);
        // if (type != null && bodyPart != null) {
        // logger.info("Searching exercises for type {} and body part {}", type,
        // bodyPart);
        // result.addAll(exercises.findByTypeAndBodyPart(type, bodyPart));

        // } else if (type != null && bodyPart == null) {
        // logger.info("Searching exercises for type {} ", type);
        // } else {

        // logger.info("Searching exercises for body part {}", bodyPart);
        // }
        // }

        if (result != null && !result.isEmpty()) {
            return new ResponseEntity<List<Exercise>>(result, HttpStatus.OK);
        } else {
            throw new NoExercises(String.format("No exercises found for type %s", type));
        }
    }

    private Exercise getByName(String name) {
        return exercises.findByName(name).orElseThrow(() -> new ExerciseDoesNotExist(name));
    }

}
