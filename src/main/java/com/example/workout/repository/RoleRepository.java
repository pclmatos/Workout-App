package com.example.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.workout.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
