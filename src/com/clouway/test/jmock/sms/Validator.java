package com.clouway.test.jmock.sms;

import com.clouway.test.jmock.sms.SMS;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public interface Validator {
    boolean isValidMessage(SMS sms);
}
