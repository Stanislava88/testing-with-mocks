package com.clouway.message;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageRangeValidatorTest {
    private Validator validator = new MessageRangeValidator(0, 120);

    @Test
    public void happyPath() throws Exception {
        Message message = new Message("recipient", "title", "content");
        boolean result = validator.isValid(message);

        assertThat(result, is(true));
    }

    @Test
    public void detectedIsMessageOutOfRange() throws Exception {
        Message message = new Message("recipient", "title", "content" +
                "content" + "content" + "content" + "content" + "content" +
                "content" + "content" + "content" + "content" + "content" +
                "content" + "content" + "content" + "content" + "content" +
                "content" + "content" + "content" + "content" + "content");
        boolean result = validator.isValid(message);

        assertThat(result, is(false));
    }
}
