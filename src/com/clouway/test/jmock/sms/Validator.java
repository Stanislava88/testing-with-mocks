package com.clouway.test.jmock.sms;

import com.clouway.test.jmock.sms.SMS;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/30/15
 */
public interface Validator {
   boolean isValid(SMS sms);
}
