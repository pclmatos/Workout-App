package com.example.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workout.model.Gender;

@Repository
public interface GenderRepository extends CrudRepository<Gender, Long> {

}
