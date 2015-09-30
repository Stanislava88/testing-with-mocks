package com.clouway.FakeSmsGateway;

import com.clouway.Sms.Message;
import com.clouway.Sms.Recipient;
import com.clouway.Sms.Sender;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by clouway on 15-9-29.
 */
public class FakeMessageSenderTest {
    FakeSmsGateway fakeSmsGateway = new FakeSmsGateway();

    @Test
    public void happyPath(){
        Message message = new Message("Zdravey","Kak si?");
        Recipient recipient = new Recipient("0883497259");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat("Zdravey", is(equalTo(fakeSmsGateway.headerText)));
        assertThat("Kak si?",is(equalTo(fakeSmsGateway.messageText)));
        assertThat("0883497259",is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithMoreThanOneHundredAndTwentySymbols(){
        Message message = new Message("Zdravey","Kak siiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii?");
        Recipient recipient = new Recipient("0883497259");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithLessThanOneSymbol(){
        Message message = new Message("Zdravey","");
        Recipient recipient = new Recipient("0883497259");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithEmptyHeader(){
        Message message = new Message("","Kak si?");
        Recipient recipient = new Recipient("0883497259");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithEmptyReciever(){
        Message message = new Message("Zdravey","Kak si?");
        Recipient recipient = new Recipient("");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithNullText(){
        Message message = new Message("Zdravey",null);
        Recipient recipient = new Recipient("");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithNullHeader(){
        Message message = new Message(null,"Kak si?");
        Recipient recipient = new Recipient("");
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }

    @Test
    public void tryToSendMessageWithNullRecipient(){
        Message message = new Message("Zdravey","Kak si?");
        Recipient recipient = new Recipient(null);
        Sender sender = new Sender(recipient,fakeSmsGateway);
        sender.sendMessage(message);
        assertThat(null, is(equalTo(fakeSmsGateway.headerText)));
        assertThat(null,is(equalTo(fakeSmsGateway.messageText)));
        assertThat(null,is(equalTo(fakeSmsGateway.recipientNumber)));
    }


}
