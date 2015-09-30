package com.clouway.FakeSmsGateway;

import com.clouway.Sms.Message;
import com.clouway.Sms.Recipient;
import com.clouway.Sms.SmsGateway;

/**
 * Created by clouway on 15-9-28.
 */
public class FakeSmsGateway implements SmsGateway {
    String messageText;
    String headerText;
    String recipientNumber;

    @Override
    public void sendMessage(Message message, Recipient recipient) {
        recipientNumber = recipient.getPhoneNumber();
        headerText = message.header;
        messageText = message.text;
    }
}
