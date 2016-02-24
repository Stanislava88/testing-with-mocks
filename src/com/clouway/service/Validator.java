package com.clouway.service;

/**
 * This interface represent validation of years of users
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface Validator {
    /**
     * Will return true if age is range from 10 to 100 and false otherwise
     * @param age Inspected object
     * @return true or false of validation
     */
    boolean isValid(String age);
}
