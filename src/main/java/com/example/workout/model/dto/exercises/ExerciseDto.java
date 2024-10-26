package com.example.workout.model.dto.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.workout.model.Exercise;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExerciseDto {

    private long id;
    private String name;
    private String bodyPart;
    private String type;

    public ExerciseDto(Exercise exercise) {
        this.id = exercise.getId();
        this.name = exercise.getName();
        this.bodyPart = exercise.getBodyPart().getName();
        this.type = exercise.getType().getName();
    }

}
