package com.example.workout.data.dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class WorkoutDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "workout")
    private List<ExerciseInWorkoutDAO> exercises;

    public WorkoutDAO(List<ExerciseInWorkoutDAO> exercises) {
        this.exercises = exercises;
    }

    public long getId() {
        return id;
    }

    public List<ExerciseInWorkoutDAO> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return String.format("WorkoutDAO [id=%d, exercises=%s]", id, exercises);
    }

}
