package com.clouway.message;

/**
 * This interface represent validation of message
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface Validator {
    /**
     * Will return true if message is valid or return false otherwise
     *
     * @param message Inspected object
     * @return a report that report result of validation
     */

    boolean isValid(Message message);
}
