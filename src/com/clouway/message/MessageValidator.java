package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageValidator implements Validator {
    private final int maxTextSize;

    public MessageValidator(int maxTextSize) {
        this.maxTextSize = maxTextSize;
    }

    @Override
    public boolean isValid(Message message) {
        if (message.recipient == null || (message.title == null) || (message.content == null)) {
            return false;
        }

        if (message.recipient.equals("") || (message.title.equals("")) || (message.content.equals("")) || message.content.length() > maxTextSize) {
            return false;
        }
        return true;
    }
}

