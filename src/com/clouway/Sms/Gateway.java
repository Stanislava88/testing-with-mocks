package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public interface Gateway {
    void recieveMessage(Message message, Reciever reciever);
}
