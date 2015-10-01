package com.clouway.test.validator;

import com.clouway.test.jmock.sms.SMS;
import com.clouway.test.jmock.validator.MessageValidator;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/30/15
 */
public class MessageValidatorImplTest {
    private MessageValidator messageValidator;

    @Before
    public void setUp() {
        messageValidator = new MessageValidator();
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
        final SMS sms = new SMS("0885390213", "", "zdravei ivan");
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithEmptyMessageField() throws Exception {
        final SMS sms = new SMS("0885390213", "do ivan", "");
        assertFalse(messageValidator.isValid(sms));
    }

    @Test
    public void sendSMSWithLegthMoreThanMaxLength() throws Exception {
        final SMS sms = new SMS("0885390213", "do ivan", "fjdfhdjkfhdjkfhdjkfhdjkfhdjkhfdjkfhdjkhfjkdhfdjkhfjdkhfjkdhfdjkhfjkdhfdjkhfdjkfhdjkfhdjkfhdjkfhdjkfhdjkfhdjkjfhdjfhdjkfhdjkfdhfj");
        assertFalse(messageValidator.isValid(sms));
    }
}
