package com.clouway.jmock.smstests;

import com.clouway.test.jmock.sms.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/8/15.
 */
public class SMSTests {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    Gateway gateway;

    @Mock
    Validator validator;


    @Test
    public void sendValidMessage() throws Exception {

        RandomMessageGenerator randomMessageGenerator = new RandomMessageGenerator();

        SmsSendService smsSendService = new SmsSendService(gateway,validator);

        SMS sms = new SMS("0883349583","do ivan",randomMessageGenerator.generateMessage(20));

        context.checking(new Expectations(){
            {
                oneOf(validator).isValidMessage(sms);
                will(returnValue(true));
                oneOf(gateway).sendSMS(sms);
            }
        });
        smsSendService.sendSMS(sms);
    }

    @Test
    public void sendInvalidMessage() throws Exception {

        RandomMessageGenerator randomMessageGenerator = new RandomMessageGenerator();

        SmsSendService smsSendService = new SmsSendService(gateway,validator);

        SMS sms = new SMS("","do ivan",randomMessageGenerator.generateMessage(20));

        context.checking(new Expectations(){
            {
                oneOf(validator).isValidMessage(sms);
                will(returnValue(false));
            }
        });
        smsSendService.sendSMS(sms);
    }
}
