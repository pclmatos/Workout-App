package com.example.workout.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ExerciseInWorkout exercise;

    private int weight;
    private int reps;

    public Set(ExerciseInWorkout exercise, int weight, int reps) {
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public ExerciseInWorkout getExercise() {
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
        return "Set [id=" + id + ", exercise=" + exercise + ", weight=" + weight + ", reps=" + reps + "]";
    }

}
