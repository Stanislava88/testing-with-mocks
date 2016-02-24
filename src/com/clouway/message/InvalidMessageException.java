package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class InvalidMessageException extends RuntimeException {
    public InvalidMessageException(String msg) {
        super(msg);
    }
}
