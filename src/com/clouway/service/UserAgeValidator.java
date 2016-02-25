package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserAgeValidator implements AgeValidator {
    private int minAge;
    private int maxAge;

    public UserAgeValidator(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean isValid(String age) {
        if (!age.matches("[0-9]+")) {
            return false;
        }
        return !(Integer.parseInt(age) < minAge || Integer.parseInt(age) > maxAge);
    }
}