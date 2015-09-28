package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public class Message {
    public final String header;
    public final String text;

    public Message(String header, String text) {
        this.header = header;
        this.text = text;
    }
}
