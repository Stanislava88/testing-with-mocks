package com.clouway.jmock.smstests;

import com.clouway.test.jmock.message.RandomMessageGenerator;
import com.clouway.test.jmock.message.Message;
import com.clouway.test.jmock.message.MessageValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class MessageValidatorTest {
    private MessageValidator messageValidator;
    private RandomMessageGenerator randomMessageGenerator;

    @Before
    public void setUp() {

        messageValidator = new MessageValidator();
        randomMessageGenerator = new RandomMessageGenerator();
    }

    @Test
    public void sendValidSMS() throws Exception {
        final Message sms = new Message("0885390213", "do ivan",randomMessageGenerator.generateMessage(12));

        assertTrue(messageValidator.isValid(sms));
    }

    @Test
    public void sendSmsWithEmptyRecipientField() throws Exception {
        final Message sms = new Message("", "do ivan", randomMessageGenerator.generateMessage(20));
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithEmptyTitleField() throws Exception {
        final Message sms = new Message("0885390213", "", randomMessageGenerator.generateMessage(20));
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithEmptyMessageField() throws Exception {
        final Message sms = new Message("0885390213", "do ivan", "");
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithLegthMoreThanMaxLength() throws Exception {
        final Message sms = new Message("0885390213", "do ivan", randomMessageGenerator.generateMessage(121));
        assertFalse(messageValidator.isValid(sms));
    }
}
