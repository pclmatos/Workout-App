package com.example.workout.data.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class SetDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ExerciseInWorkoutDAO exercise;

    private int weigth;
    private int reps;

    public SetDAO(ExerciseInWorkoutDAO exercise, int weigth, int reps) {
        this.exercise = exercise;
        this.weigth = weigth;
        this.reps = reps;
    }

    public long getId() {
        return id;
    }

    public ExerciseInWorkoutDAO getExercise() {
        return exercise;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getReps() {
        return reps;
    }

    @Override
    public String toString() {
        return "SetDAO [id=" + id + ", exercise=" + exercise + ", weigth=" + weigth + ", reps=" + reps + "]";
    }

}
