package com.clouway.fakesmsgateway;

import com.clouway.sms.Message;
import com.clouway.sms.Recipient;
import com.clouway.sms.SmsGateway;

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
