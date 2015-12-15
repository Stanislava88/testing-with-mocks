package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class SMSValidator implements Validator {
    private final int numberLength;
    private final MessageRange messageRange;

    public SMSValidator(int numberLength, MessageRange messageRange) {
        this.numberLength = numberLength;
        this.messageRange = messageRange;
    }

    @Override
    public boolean validate(String number, String title, String message) {
        return validateTitle(title) && validateMessage(message) && validateNumber(number);
    }

    private boolean validateMessage(String message) {
        return messageRange.isBetweenRange(message.length());
    }

    private boolean validateTitle(String title) {
        return title.length() > 0;
    }

    private boolean validateNumber(String number) {
        return number.length() == numberLength;
    }


}
