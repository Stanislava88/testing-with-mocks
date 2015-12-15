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
    public boolean validate(Recipient recipient, String title, String message) throws InvalidSMSException {
        return validateNumber(recipient) && validateTitle(title) && validateMessage(message);
    }

    private boolean validateMessage(String message) throws InvalidSMSException {
        if (messageRange.isBetweenRange(message.length())) {
            return true;
        } else {
            throw new InvalidSMSException("Invalid message length");
        }
    }

    private boolean validateTitle(String title) throws InvalidSMSException {
        if (title.length() > 0) {
            return true;
        } else {
            throw new InvalidSMSException("Invalid title");
        }
    }

    private boolean validateNumber(Recipient recipient) throws InvalidSMSException {
        if (recipient.numberLength() == numberLength && recipient.numberOnlyDigits()) {
            return true;
        } else {
            throw new InvalidSMSException("Invalid recipient number");
        }
    }


}
