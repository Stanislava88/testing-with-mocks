package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageValidator implements Validator {

    @Override
    public boolean isValid(Message message) {
        if (message.recipient == null || (message.title == null) || (message.content == null)) {
            throw new NullPointerException("Detected is null value!");
        } else if (message.recipient.equals("") || (message.title.equals("")) || (message.content.equals(""))) {
            throw new InvalidMessageException(message.recipient, message.title, message.content);
        } else {
            return true;
        }
    }
}
