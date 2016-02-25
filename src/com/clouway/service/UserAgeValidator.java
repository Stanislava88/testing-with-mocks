package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserAgeValidator implements AgeValidator {
    private int minAge;
    private int max;
    private int minAdultAge;

    public UserAgeValidator(int minAge, int maxAge, int adultAge) {
        this.minAge = minAge;
        this.max = maxAge;
        this.minAdultAge = adultAge;
    }

    @Override
    public boolean isAgeValid(String age) {
        if (!age.matches("[0-9]+")) {
            return false;
        }
        return !(Integer.parseInt(age) < minAge || Integer.parseInt(age) > max);
    }

    @Override
    public boolean isAgeAdult(String age) {
        return Integer.parseInt(age) > minAdultAge;
    }
}