package com.clouway.message;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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

    @Test(expected = InvalidMessageException.class)
    public void detectIsMessageWithoutRecipient() throws Exception {
        String recipient = "";
        String title = "title";
        String content = "content";
        Message message = new Message(recipient, title, content);

        validator.isValid(message);
    }

    @Test(expected = InvalidMessageException.class)
    public void detectIsMessageWithoutTitle() throws Exception {
        String recipient = "recipient";
        String title = "";
        String content = "content";
        Message message = new Message(recipient, title, content);

        validator.isValid(message);
    }

    @Test(expected = InvalidMessageException.class)
    public void detectIsEmptyMessage() throws Exception {
        String recipient = "recipient";
        String title = "title";
        String content = "";
        Message message = new Message(recipient, title, content);

        validator.isValid(message);
    }

    @Test(expected = InvalidMessageException.class)
    public void detectedIsMessageWithoutTitleAndRecipient() throws Exception {
        String recipient = "";
        String title = "";
        String content = "";
        Message message = new Message(recipient, title, content);

        validator.isValid(message);
    }

    @Test(expected = NullPointerException.class)
    public void detectedIsNullValue() throws Exception {
        String content = "content";
        Message message = new Message(null, null, content);

        validator.isValid(message);
    }

    @Test(expected = InvalidMessageException.class)
    public void detectedIsMessageOutOfRange() throws Exception {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 120; i++) {
            buffer.append("content");
        }

        String content = buffer.toString();
        String recipient = "recipient";
        String title = "title";
        Message message = new Message(recipient, title, content);

        validator.isValid(message);
    }
}

