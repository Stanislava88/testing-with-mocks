package com.clouway.test.jmock.sms;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class SMS {

    public final String recipient;
    public final String title;
    public final String message;

    /**
     * @param recipient is recepient which receive message.
     * @param title     is a message title.
     * @param message   is message which we send.
     */
    public SMS(String recipient, String title, String message) {
        this.recipient = recipient;
        this.title = title;
        this.message = message;
    }

}

