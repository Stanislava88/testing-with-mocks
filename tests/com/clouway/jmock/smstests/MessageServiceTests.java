package com.clouway.jmock.smstests;

import com.clouway.test.jmock.message.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.auto.Mock;;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/8/15.
 */
public class MessageServiceTests {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    Gateway gateway;

    @Mock
    Validator validator;


    @Test
    public void sendValidMessage() throws Exception {

        RandomMessageGenerator randomMessageGenerator = new RandomMessageGenerator();

        MessageService smsSendService = new MessageService(gateway, validator);

        Message message = new Message("0883349583", "do ivan", randomMessageGenerator.generateMessage(20));

        context.checking(new Expectations() {
            {
                oneOf(validator).isValidMessage(message);
                will(returnValue(true));
                oneOf(gateway).sendMessage(message);
            }
        });
        smsSendService.sendMessage(message);

        assertTrue(validator.isValidMessage(message));
    }


    @Test
    public void sendInvalidMessage() throws Exception {

        RandomMessageGenerator randomMessageGenerator = new RandomMessageGenerator();

        MessageService smsSendService = new MessageService(gateway, validator);

        Message message = new Message("", "do ivan", randomMessageGenerator.generateMessage(20));

        context.checking(new Expectations() {
            {
                oneOf(validator).isValidMessage(message);
                will(returnValue(false));
            }
        });

        smsSendService.sendMessage(message);

        assertFalse(validator.isValidMessage(message));
    }
}
