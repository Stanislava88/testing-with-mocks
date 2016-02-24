package com.clouway.message;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageValidatorTest {
    private Validator validator = new MessageValidator(123);

    @Test
    public void happyPath() throws Exception {
        String recipient = "recipient";
        String title = "title";
        String content = "content";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(true));
    }

    @Test
    public void missingRecipient() throws Exception {
        String recipient = "";
        String title = "title";
        String content = "content";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void missingTitle() throws Exception {
        String recipient = "recipient";
        String title = "";
        String content = "content";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void missingContent() throws Exception {
        String recipient = "recipient";
        String title = "title";
        String content = "";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void missingMessage() throws Exception {
        String recipient = "";
        String title = "";
        String content = "";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void validateNuLLMessage() throws Exception {
        Message message = new Message(null, null, null);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void validateLargeMessage() throws Exception {
        Validator validator = new MessageValidator(2);

        String recipient = "recipient";
        String title = "content";
        String content = "sdsdsds";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }
}

