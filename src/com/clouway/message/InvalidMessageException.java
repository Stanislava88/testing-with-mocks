package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class InvalidMessageException extends RuntimeException {
    private String recipient;
    private String title;
    private String content;

    public InvalidMessageException(String recipient, String title, String content) {
        this.recipient = recipient;
        this.title = title;
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
