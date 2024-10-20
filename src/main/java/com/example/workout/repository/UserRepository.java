package com.example.workout.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workout.data.dao.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> { // Assuming User is the entity class for
                                                                           // users{
    Optional<UserDAO> findByUsername(String username);
}
