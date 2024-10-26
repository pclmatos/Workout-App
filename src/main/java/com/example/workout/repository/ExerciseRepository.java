package com.example.workout.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

import com.example.workout.model.BodyPart;
import com.example.workout.model.Exercise;
import com.example.workout.model.ExerciseType;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

    @Query(value = "SELECT e FROM Exercise e WHERE e.name LIKE CONCAT('%', ?1, '%')")
    List<Exercise> findByNameContaining(String name);

    List<Exercise> findByTypeAndBodyPart(ExerciseType type, BodyPart bodyPart);

    List<Exercise> findByType(ExerciseType type);

    List<Exercise> findByBodyPart(BodyPart bodyPart);

}
