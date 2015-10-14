package com.clouway.sms;

/**
 * Created by clouway on 15-9-25.
 */
public interface SmsGateway {
    void sendMessage(Message message, Recipient recipient);
}
