package com.example.workout.service.impl;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.workout.common.exception.exercises.ExerciseDoesNotExist;
import com.example.workout.common.exception.exercises.ExerciseExists;
import com.example.workout.common.exception.exercises.NoExercises;
import com.example.workout.common.utils.BodyPart;
import com.example.workout.common.utils.ExerciseType;
import com.example.workout.data.dao.ExerciseDAO;
import com.example.workout.data.dto.exercises.AddExerciseDTO;
import com.example.workout.data.dto.exercises.UpdateExerciseDTO;
import com.example.workout.repository.ExerciseRepository;
import com.example.workout.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);

    @Autowired
    private ExerciseRepository exercises;

    @Override
    public ResponseEntity<List<ExerciseDAO>> getAll() {
        List<ExerciseDAO> list = (List<ExerciseDAO>) exercises.findAll();
        if (list.isEmpty()) {
            throw new NoExercises();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ExerciseDAO> addExercise(AddExerciseDTO dto) {

        ExerciseDAO exerciseDAO;
        try {
            exerciseDAO = getByName(dto.getName());
            if (exerciseDAO != null) {
                logger.error("Exercise {} already exists", dto.getName());
                throw new ExerciseExists(dto.getName());
            }

        } catch (ExerciseDoesNotExist e) {

            logger.debug("Adding exercise {} of type {} and body part {}", dto.getName(),
                    ExerciseType.valueOf(dto.getType()),
                    BodyPart.valueOf(dto.getBodyPart()));

            exerciseDAO = new ExerciseDAO(0, dto.getName(), ExerciseType.valueOf(dto.getType()),
                    BodyPart.valueOf(dto.getBodyPart()));
        }
        return new ResponseEntity<ExerciseDAO>(
                exercises.save(exerciseDAO),
                HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<ExerciseDAO> findByName(String name) {

        ExerciseDAO exerciseDAO = getByName(name);

        return new ResponseEntity<ExerciseDAO>(exerciseDAO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExerciseDAO> updateExercise(String name, UpdateExerciseDTO dto) {
        ExerciseDAO exercise = getByName(name);
        exercise.setName(dto.getName());

        return new ResponseEntity<ExerciseDAO>(exercise, HttpStatus.OK);
    }

    private ExerciseDAO getByName(String name) {
        return exercises.findByName(name).orElseThrow(() -> new ExerciseDoesNotExist(name));
    }

    @Override
    public ResponseEntity<Set<ExerciseDAO>> searchExercises(String type, String bodyPart, String name) {

        Set<ExerciseDAO> result = new HashSet<>();
        if (name != null) {
            ExerciseDAO exercise = getByName(name);
            result.add(exercise);
        } else {
            if (type != null && bodyPart != null) {
                logger.info("Searching exercises for type {} and body part {}", type, bodyPart);
                result.addAll(exercises.findByTypeAndBodyPart(ExerciseType.valueOf(type),
                        BodyPart.valueOf(bodyPart)));

            } else if (type != null && bodyPart == null) {

                logger.info("Searching exercises for type {} ", type);
                Set<ExerciseDAO> typeSet = exercises.findByType(ExerciseType.valueOf(type));
                result.addAll(typeSet);
            } else {

                logger.info("Searching exercises for body part {}", bodyPart);
                Set<ExerciseDAO> bodyPartSet = exercises.findByBodyPart(BodyPart.valueOf(bodyPart));
                result.addAll(bodyPartSet);

            }
        }

        if (!result.isEmpty()) {
            return new ResponseEntity<Set<ExerciseDAO>>(result, HttpStatus.OK);
        } else {
            throw new NoExercises(String.format("No exercises found for type %s", type));
        }
    }

}
