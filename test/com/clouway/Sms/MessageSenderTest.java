package com.clouway.Sms;


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
    Gateway gateway;

    @Test
    public void HappyPathTest() {
        final Message message = new Message("Header", "Text");
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            oneOf(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void TryToSendMessageWithMoreThanOneHundredAndTwentySymbols() {
        final Message message = new Message("Header", "TextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextTextText");
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);
    }

    ;


    @Test
    public void TryToSendMessageWithLessThanOneSymbol() {
        final Message message = new Message("Header", "");
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);
    }

    @Test
    public void TryToSendMessageWithEmptyHeader() {
        final Message message = new Message("", "Text");
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void TryToSendMessageWithEmptyReciever() {
        final Message message = new Message("Header", "Text");
        final Reciever reciever = new Reciever("");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void TryToSendMessageWithNullText() {
        final Message message = new Message("Header", null);
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);

    }

    @Test
    public void TryToSendMessageWithNullHeader() {
        final Message message = new Message(null, "Text");
        final Reciever reciever = new Reciever("0883497259");
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);
    }

    @Test
    public void TryToSendMessageWithNullReciever() {
        final Message message = new Message(null, "Text");
        final Reciever reciever = new Reciever(null);
        Sender sender = new Sender(reciever, gateway);
        context.checking(new Expectations() {{
            never(gateway).recieveMessage(message, reciever);
        }});
        sender.sendMessage(message);
    }
}
