package com.example.workout.model.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private long gender;
    private int age;
    private double weight;
    private double height;

    @Override
    public String toString() {
        return "RegisterDto [name=" + name + ", surname=" + surname + ", username=" + username + ", password="
                + password + ", email=" + email + ", gender=" + gender + ", age=" + age + ", weight=" + weight
                + ", height=" + height + "]";
    }

}
