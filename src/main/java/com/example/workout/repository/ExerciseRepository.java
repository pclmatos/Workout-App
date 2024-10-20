package com.example.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import com.example.workout.common.utils.BodyPart;
import com.example.workout.common.utils.ExerciseType;
import com.example.workout.data.dao.ExerciseDAO;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseDAO, Integer> {

    Optional<ExerciseDAO> findByName(String name);

    Set<ExerciseDAO> findByTypeAndBodyPart(ExerciseType type, BodyPart bodyPart);

    Set<ExerciseDAO> findByType(ExerciseType type);

    Set<ExerciseDAO> findByBodyPart(BodyPart bodyPart);

}
