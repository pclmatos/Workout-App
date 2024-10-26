package com.example.workout.model.dto.exercises;

public class UpdateExerciseDto {

    private String name;
    private int type;
    private int body_part;

    public UpdateExerciseDto() {

    }

    public UpdateExerciseDto(String name, int type, int body_part) {
        this.name = name;
        this.type = type;
        this.body_part = body_part;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getBody_part() {
        return body_part;
    }

}
