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
        Message message = new Message("recipient", "title", "content");
        boolean result = validator.isValid(message);

        assertThat(result, is(true));
    }

    @Test
    public void detectIsMessageWithoutRecipient() throws Exception {
        Message message = new Message("", "title", "content");

        try {
            validator.isValid(message);
            fail("Exception should be thrown! The recipient can't be empty");
        } catch (InvalidMessageException ex) {

            assertThat(ex.getRecipient(), is(""));
        }
    }

    @Test
    public void detectIsMessageWithoutTitle() throws Exception {
        Message message = new Message("recipient", "", "content");

        try {
            validator.isValid(message);
            fail("Exception should be thrown! The title can't be empty");
        } catch (InvalidMessageException ex) {

            assertThat(ex.getTitle(), is(equalTo("")));
        }
    }

    @Test
    public void detectIsEmptyMessage() throws Exception {
        Message message = new Message("recipient", "title", "");

        try {
            validator.isValid(message);
            fail("Exception should be thrown! The content can't be empty");
        } catch (InvalidMessageException ex) {

            assertThat(ex.getContent(), is(equalTo("")));
        }
    }

    @Test(expected = InvalidMessageException.class)
    public void detectedIsMessageWithoutTitleAndRecipient() throws Exception {
        Message message = new Message("", "", "content");
        validator.isValid(message);
    }

    @Test(expected = NullPointerException.class)
    public void detectedIsNullValue() throws Exception {
        Message message = new Message(null, null, "content");
        validator.isValid(message);
    }
}

