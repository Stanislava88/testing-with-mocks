package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public class Sender {
    public final SmsGateway smsGateway;
    public final Recipient recipient;

    public Sender(Recipient recipient, SmsGateway smsGateway) {
        this.recipient = recipient;
        this.smsGateway = smsGateway;
    }

    public void sendMessage(Message message) {
        if (message.text == null || message.header == null || recipient.getPhoneNumber() == null) {
            return;
        }
        if (message.checkIfMessageIsAppropriate() && recipient.checkIfRecipientNumberIsAppropriate()) {
            smsGateway.sendMessage(message, recipient);
        }

    }
}
