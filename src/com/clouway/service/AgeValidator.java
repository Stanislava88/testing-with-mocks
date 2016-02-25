package com.clouway.service;

/**
 * This interface represent validation of years of users
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface AgeValidator {
    /**
     * Will return true if age is range from 10 to 100 and false otherwise
     *
     * @param age Inspected object
     * @return true or false of age validation
     */
    boolean isAgeValid(String age);

    /**
     * Will return true if user is adult and false otherwise
     *
     * @param name
     * @return true or false
     */

    boolean isAgeAdult(String name);
}
