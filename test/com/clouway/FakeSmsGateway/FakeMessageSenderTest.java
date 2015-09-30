package com.clouway.FakeSmsGateway;

import com.clouway.Sms.Message;
import com.clouway.Sms.Recipient;
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
    @Test
    public void happyPath(){
        FakeSmsGateway fakeSmsGateway = new FakeSmsGateway();
        Message message = new Message("Zdravey","Kak si?");
        Recipient recipient = new Recipient("0883497259");
        fakeSmsGateway.sendMessage(message,recipient);
        assertThat("Zdravey", is(equalTo(fakeSmsGateway.headerText)));
        assertThat("Kak si?",is(equalTo(fakeSmsGateway.messageText)));
        assertThat("0883497259",is(equalTo(fakeSmsGateway.recipientNumber)));
    }
}
