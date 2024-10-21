package com.example.workout.data.dto.exercises;

public class AddExerciseDto {

    private String name;
    private String bodyPart;
    private String type;

    public AddExerciseDto() {
    }

    public AddExerciseDto(String name, String bodyPart, String type) {
        this.name = name;
        this.bodyPart = bodyPart;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getType() {
        return type;
    }

}
