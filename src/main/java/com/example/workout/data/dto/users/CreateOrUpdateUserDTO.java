package com.example.workout.data.dto.users;

public class CreateOrUpdateUserDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int gender;
    private int age;
    private double weight;
    private double height;

    private CreateOrUpdateUserDTO() {

    }

    private CreateOrUpdateUserDTO(String username, String password, String firstName, String lastName, String email,
            int gender, int age,
            double weight, double height) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

}
