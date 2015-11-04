package com.clouway.test.jmock.message;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class MessageValidator {
    /**
     * @param message is a message which validator validate before send.
     * @return true if conditions is satisfied or false conditons is not satisfied.
     */

    public boolean isValid(Message message) {
        if (message.body.equals("") || message.title.equals("") || message.recipient.equals("")) {
            return false;
        }
        if (message.body.length() < 1 || message.body.length() > 120) {
            return false;
        }
        return true;
    }
}
