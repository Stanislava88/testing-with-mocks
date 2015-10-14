package com.clouway.sms;

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

    public boolean checkIfMessageIsAppropriate() {
        if (text.length() >= 1 && text.length() <= 120 && header.length() > 1) {
            return true;
        } else {
            return false;
        }
    }
}
