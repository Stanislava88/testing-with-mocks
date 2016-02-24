package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageRangeValidator implements Validator {
    private final int minValue;
    private final int maxValue;

    public MessageRangeValidator(int minValue, int maxValue) {

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean isValid(Message message) {
        if (message.content.length() > minValue && message.content.length() < maxValue) {
            return true;
        }
        return false;
    }
}
