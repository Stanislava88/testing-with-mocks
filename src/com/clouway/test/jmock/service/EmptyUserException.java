package com.clouway.test.jmock.service;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class EmptyUserException extends RuntimeException {
    public EmptyUserException(String message) {
        super(message);
    }
}
