package com.example.workout.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import com.example.workout.common.utils.BodyPart;
import com.example.workout.common.utils.ExerciseType;
import com.example.workout.data.dao.ExerciseDao;

@Repository
public interface ExerciseRepository extends CrudRepository<ExerciseDao, Integer> {

    Optional<ExerciseDao> findByName(String name);

    @Query(value = "SELECT e FROM ExerciseDao e WHERE e.name LIKE CONCAT('%', ?1, '%')")
    Set<ExerciseDao> findByNameContaining(String name);

    Set<ExerciseDao> findByTypeAndBodyPart(ExerciseType type, BodyPart bodyPart);

    Set<ExerciseDao> findByType(ExerciseType type);

    Set<ExerciseDao> findByBodyPart(BodyPart bodyPart);

}
