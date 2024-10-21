package com.example.workout.service.impl;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

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
import com.example.workout.data.dao.ExerciseDao;
import com.example.workout.data.dto.exercises.AddExerciseDto;
import com.example.workout.data.dto.exercises.UpdateExerciseDto;
import com.example.workout.repository.ExerciseRepository;
import com.example.workout.service.ExerciseService;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final Logger logger = LoggerFactory.getLogger(ExerciseServiceImpl.class);

    @Autowired
    private ExerciseRepository exercises;

    @Override
    public ResponseEntity<List<ExerciseDao>> getAll() {
        List<ExerciseDao> list = (List<ExerciseDao>) exercises.findAll();
        if (list.isEmpty()) {
            throw new NoExercises();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ExerciseDao> addExercise(AddExerciseDto dto) {

        ExerciseDao exerciseDAO;
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

            exerciseDAO = new ExerciseDao(0, dto.getName(), ExerciseType.valueOf(dto.getType()),
                    BodyPart.valueOf(dto.getBodyPart()));
        }
        return new ResponseEntity<ExerciseDao>(
                exercises.save(exerciseDAO),
                HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<ExerciseDao> findByName(String name) {

        ExerciseDao exerciseDAO = getByName(name);

        return new ResponseEntity<ExerciseDao>(exerciseDAO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ExerciseDao> updateExercise(String name, UpdateExerciseDto dto) {
        ExerciseDao exercise = getByName(name);
        exercise.setName(dto.getName());

        return new ResponseEntity<ExerciseDao>(exercise, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<ExerciseDao>> searchExercises(String name, String type, String bodyPart) {
        logger.info("Searching exercises for name {}", name);
        Set<ExerciseDao> result = new HashSet<>();
        if (name != null) {
            Set<ExerciseDao> set = exercises.findByNameContaining(name);
            result.addAll(set);
        } else {
            if (type != null && bodyPart != null) {
                logger.info("Searching exercises for type {} and body part {}", type, bodyPart);
                result.addAll(exercises.findByTypeAndBodyPart(ExerciseType.valueOf(type),
                        BodyPart.valueOf(bodyPart)));

            } else if (type != null && bodyPart == null) {

                logger.info("Searching exercises for type {} ", type);
                Set<ExerciseDao> typeSet = exercises.findByType(ExerciseType.valueOf(type));
                result.addAll(typeSet);
            } else {

                logger.info("Searching exercises for body part {}", bodyPart);
                Set<ExerciseDao> bodyPartSet = exercises.findByBodyPart(BodyPart.valueOf(bodyPart));
                result.addAll(bodyPartSet);

            }
        }

        if (!result.isEmpty()) {
            return new ResponseEntity<Set<ExerciseDao>>(result, HttpStatus.OK);
        } else {
            throw new NoExercises(String.format("No exercises found for type %s", type));
        }
    }

    private ExerciseDao getByName(String name) {
        return exercises.findByName(name).orElseThrow(() -> new ExerciseDoesNotExist(name));
    }

}
