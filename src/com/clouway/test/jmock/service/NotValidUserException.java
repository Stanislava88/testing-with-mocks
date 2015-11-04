package com.clouway.test.jmock.service;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class NotValidUserException extends Throwable {
    public NotValidUserException(String message) {
        super(message);
    }
}
