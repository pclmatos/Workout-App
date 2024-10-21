package com.example.workout.common.utils;

public enum Gender {
    MALE(1),
    FEMALE(2);

    private final int gender;

    Gender(int gender) {
        this.gender = gender;
    }

    public int getValue() {
        return gender;
    }

    public static Gender fromValue(int value) {
        for (Gender g : Gender.values()) {
            if (g.getValue() == value) {
                return g;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

}
