package com.example.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workout.model.BodyPart;

import java.util.Optional;

@Repository
public interface BodyPartRepository extends CrudRepository<BodyPart, Long> {

    Optional<BodyPart> findByName(String name);

}
