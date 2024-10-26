package com.example.workout.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workout.model.ExerciseType;

@Repository
public interface ExerciseTypeRepository extends CrudRepository<ExerciseType, Long> {

    Optional<ExerciseType> findByName(String name);

}
