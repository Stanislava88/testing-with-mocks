package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageValidator implements Validator {

    @Override
    public boolean isValid(Message message) {
        if (message.recipient == null || (message.title == null) || (message.content == null)) {
            return false;
        } else if (message.recipient.equals("") || (message.title.equals("")) || (message.content.equals("")) || message.content.length() > 120) {
            return false;
        }
        return true;
    }
}

