package com.example.workout.data.dto.exercises;

public class AddExerciseDTO {

    private String name;
    private String bodyPart;
    private String type;

    public AddExerciseDTO() {
    }

    public AddExerciseDTO(String name, String bodyPart, String type) {
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
