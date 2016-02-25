package com.clouway.service;

/**
 * The implementation of this interface will be used to validate age
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface AgeValidator {
    /**
     * Will return true if age is valid and false otherwise
     *
     * @param age Inspected object
     * @return true or false of age validation
     */
    boolean isValid(String age);
}
