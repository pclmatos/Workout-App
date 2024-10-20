package com.example.workout.data.dao;

import com.example.workout.common.utils.BodyPart;
import com.example.workout.common.utils.ExerciseType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ExerciseDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private ExerciseType type;
    private BodyPart bodyPart;

    public ExerciseDAO() {
    }

    public ExerciseDAO(long id, String name, ExerciseType type, BodyPart bodyPart) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return String.format("ExerciseDAO [id=´%d´, name=´%s´]", id, name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExerciseType getType() {
        return type;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

}
