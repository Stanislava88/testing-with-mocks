package com.clouway.jmock.smstests;

import com.clouway.test.jmock.sms.RandomMessageGenerator;
import com.clouway.test.jmock.sms.SMS;
import com.clouway.test.jmock.sms.MessageValidator;
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
        final SMS sms = new SMS("0885390213", "do ivan", "zdravei ivan");

        assertTrue(messageValidator.isValid(sms));
    }

    @Test
    public void sendSmsWithEmptyRecipientField() throws Exception {
        final SMS sms = new SMS("", "do ivan", "zdravei ivan");
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithEmptyTitleField() throws Exception {
        final SMS sms = new SMS("0885390213", "", randomMessageGenerator.generateMessage("abcdefghij", 20));
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithEmptyMessageField() throws Exception {
        final SMS sms = new SMS("0885390213", "do ivan", "");
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithLegthMoreThanMaxLength() throws Exception {
        final SMS sms = new SMS("0885390213", "do ivan", randomMessageGenerator.generateMessage("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 121));
        assertFalse(messageValidator.isValid(sms));
    }
}
