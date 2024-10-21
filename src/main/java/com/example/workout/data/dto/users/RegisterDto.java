package com.example.workout.data.dto.users;

public class RegisterDto {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private int gender;
    private int age;
    private double weight;
    private double height;

    private RegisterDto() {

    }

    private RegisterDto(String username, String password, String name, String surname, String email,
            int gender, int age,
            double weight, double height) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
