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
public class ExerciseInWorkoutDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private WorkoutDao workout;

    @ManyToOne
    private ExerciseDao exercise;

    @OneToMany(mappedBy = "id")
    private List<SetDao> sets;

    public ExerciseInWorkoutDao(WorkoutDao workout, ExerciseDao exercise, List<SetDao> sets) {
        this.workout = workout;
        this.exercise = exercise;
        this.sets = sets;
    }

    public WorkoutDao getWorkout() {
        return workout;
    }

    public ExerciseDao getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        return "ExerciseInWorkoutDAO [workout=" + workout + ", exercise=" + exercise + "]";
    }

}
