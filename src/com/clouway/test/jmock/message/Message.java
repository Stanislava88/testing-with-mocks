package com.clouway.test.jmock.message;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class Message {

    public String recipient;
    public String title;
    public String body;

    /**
     * @param recipient is recepient which receive message.
     * @param title     is a message title.
     * @param body      is message which we send.
     */
    public Message(String recipient, String title, String body) {
        this.recipient = recipient;
        this.title = title;
        this.body = body;
    }
}

