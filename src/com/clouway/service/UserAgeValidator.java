package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserAgeValidator implements AgeValidator {
    private int min;
    private int max;

    public UserAgeValidator(int min, int max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean isAgeValid(String age) {
        if (!age.matches("[0-9]+")) {
            return false;
        }
        return !(Integer.parseInt(age) < min || Integer.parseInt(age) > max);
    }

    @Override
    public boolean isAgeAdult(String age) {
        return Integer.parseInt(age) > max;
    }
}