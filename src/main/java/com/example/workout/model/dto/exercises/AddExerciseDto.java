package com.example.workout.model.dto.exercises;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddExerciseDto {

    private String name;
    private String bodyPart;
    private String type;

}
