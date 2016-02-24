package com.clouway.message;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageValidatorTest {
    private Validator validator = new MessageValidator();

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
    public void detectIsMessageWithoutRecipient() throws Exception {
        String recipient = "";
        String title = "title";
        String content = "content";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void detectIsMessageWithoutTitle() throws Exception {
        String recipient = "recipient";
        String title = "";
        String content = "content";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void detectIsEmptyMessage() throws Exception {
        String recipient = "recipient";
        String title = "title";
        String content = "";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void detectedIsMessageWithoutTitleAndRecipient() throws Exception {
        String recipient = "";
        String title = "";
        String content = "";
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void detectedIsNullValue() throws Exception {
        String content = "content";
        Message message = new Message(null, null, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }

    @Test
    public void detectedIsMessageOutOfRange() throws Exception {
        String recipient = "recipient";
        String title = "content";
        String content = Strings.repeat("content", 120);
        Message message = new Message(recipient, title, content);

        boolean result = validator.isValid(message);
        assertThat(result, is(false));
    }
}

