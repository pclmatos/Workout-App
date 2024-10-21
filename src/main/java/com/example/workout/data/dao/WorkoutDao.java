package com.example.workout.data.dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class WorkoutDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "workout")
    private List<ExerciseInWorkoutDao> exercises;

    public WorkoutDao(List<ExerciseInWorkoutDao> exercises) {
        this.exercises = exercises;
    }

    public long getId() {
        return id;
    }

    public List<ExerciseInWorkoutDao> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return String.format("WorkoutDAO [id='%d', exercises='%s']", id, exercises);
    }

}
