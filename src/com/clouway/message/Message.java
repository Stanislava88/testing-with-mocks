package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class Message {
    public final String recipient;
    public final String title;
    public final String content;

    public Message(String recipient, String title, String content) {

        this.recipient = recipient;
        this.title = title;
        this.content = content;
    }
}
