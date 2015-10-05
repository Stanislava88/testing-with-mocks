package com.clouway.jmock.smstests;

import com.clouway.test.jmock.sms.Gateway;
import com.clouway.test.jmock.sms.SMS;
import com.clouway.test.jmock.sms.SmsSendService;
import com.clouway.test.jmock.sms.Validator;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class SMSTests {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    @Mock
    Gateway gateway;
    @Mock
    Validator validator;

    @Test
    public void sendSMS() {

        SmsSendService sendService = new SmsSendService(gateway, validator);

        SMS sms = new SMS("0885342134", "do ivan", "zdravei ivan");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(sms);
                will(returnValue(true));
                oneOf(gateway).sendSMS(sms);
            }
        });
        sendService.sendSMS(sms);
    }

    @Test
    public void sendInvalidSMS() throws Exception {

        SmsSendService sendService = new SmsSendService(gateway, validator);

        SMS sms = new SMS(" ", "do ivan", "zdravei ivan");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(sms);
                will(returnValue(false));
            }
        });
        sendService.sendSMS(sms);
    }

}
