package com.clouway.message;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageDispatcherTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private MessageGateway gateway = context.mock(MessageGateway.class);
    private Validator validator = context.mock(Validator.class);

    private MessageDispatcher dispatcher = new MessageDispatcher(gateway, validator);

    @Test
    public void happyPath() throws Exception {
        final Message message = new Message("recipient", "title", "content");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(message);
            will(returnValue(true));

            oneOf(gateway).send(message);
        }});

        dispatcher.send(message);
    }

    @Test
    public void sendInvalidMessage() throws Exception {
        final Message message = new Message("recipient", "", "content");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(message);
            will(returnValue(false));

            never(gateway).send(message);
        }});

        dispatcher.send(message);
    }
}
