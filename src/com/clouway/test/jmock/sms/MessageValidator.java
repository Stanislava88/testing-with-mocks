package com.clouway.test.jmock.sms;

import com.clouway.test.jmock.sms.SMS;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class MessageValidator {
    private SMS sms;

    /**
     * @param sms is a message which validator validate before send.
     * @return true if conditions is satisfied or false conditons is not satisfied.
     */

    public boolean isValid(SMS sms) {
        if (sms.message.equals("") || sms.title.equals("") || sms.recipient.equals("")) {
            return false;
        }
        if (sms.message.length() < 1 || sms.message.length() > 120) {
            return false;
        }
        return true;
    }
}
