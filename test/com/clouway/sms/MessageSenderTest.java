package com.clouway.sms;


import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by clouway on 15-9-25.
 */
public class MessageSenderTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    @Mock
    SmsGateway smsGateway;

    @Test
    public void happyPathTest() {
        final Message message = new Message("Header", "Text");
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            oneOf(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void sendLongMessage() {
        final Message message = new Message("Header", "TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText");
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);
    }

    ;


    @Test
    public void sendShortMessage() {
        final Message message = new Message("Header", "");
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);
    }

    @Test
    public void emptyHeader() {
        final Message message = new Message("", "Text");
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void emptyReciever() {
        final Message message = new Message("Header", "Text");
        final Recipient recipient = new Recipient("");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void nullText() {
        final Message message = new Message("Header", null);
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void nullHeader() {
        final Message message = new Message(null, "Text");
        final Recipient recipient = new Recipient("0883497259");
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);
    }

    @Test
    public void nullReciever() {
        final Message message = new Message("Header", "Text");
        final Recipient recipient = new Recipient(null);
        final Sender sender = new Sender(recipient, smsGateway);
        context.checking(new Expectations() {{
            never(smsGateway).sendMessage(message, recipient);
        }});
        sender.sendMessage(message);
    }
}
