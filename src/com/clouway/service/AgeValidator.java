package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class AgeValidator implements Validator {
    @Override
    public boolean isValid(String age) {
        if (!age.matches("[0-9]+")) {
            return false;
        } else if (Integer.parseInt(age) < 0 || Integer.parseInt(age) > 100) {
            return false;
        } else
            return true;
    }
}
