package com.clouway.test.jmock.message;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public interface Validator {
    boolean isValidMessage(Message message);
}
