package com.clouway.test.jmock.sms;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/30/15
 */
public class SMS {
     private String recipient;
     private String title;
     private String message;

    public SMS(String recipient, String title, String message) {
        this.recipient = recipient;
        this.title = title;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}

