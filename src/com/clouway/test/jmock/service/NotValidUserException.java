package com.clouway.test.jmock.service;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class NotValidUserException extends RuntimeException {
    public NotValidUserException(String message) {
        super(message);
    }
}
