package com.example.workout.data.dao;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class ExerciseInWorkoutDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private WorkoutDAO workout;

    @ManyToOne
    private ExerciseDAO exercise;

    @OneToMany(mappedBy = "id")
    private List<SetDAO> sets;

    public ExerciseInWorkoutDAO(WorkoutDAO workout, ExerciseDAO exercise, List<SetDAO> sets) {
        this.workout = workout;
        this.exercise = exercise;
        this.sets = sets;
    }

    public WorkoutDAO getWorkout() {
        return workout;
    }

    public ExerciseDAO getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        return "ExerciseInWorkoutDAO [workout=" + workout + ", exercise=" + exercise + "]";
    }

}
