package com.example.workout.data.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class SetDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ExerciseInWorkoutDao exercise;

    private int weight;
    private int reps;

    public SetDao(ExerciseInWorkoutDao exercise, int weight, int reps) {
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public ExerciseInWorkoutDao getExercise() {
        return exercise;
    }

    public int getWeight() {
        return weight;
    }

    public int getReps() {
        return reps;
    }

    @Override
    public String toString() {
        return "SetDAO [id=" + id + ", exercise=" + exercise + ", weight=" + weight + ", reps=" + reps + "]";
    }

}
