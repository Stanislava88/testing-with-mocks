package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class SMSMessage {
    private final Recipient recipient;
    private final String title;
    private final String message;


    public SMSMessage(Recipient recipient, String title, String message) {
        this.recipient = recipient;
        this.title = title;
        this.message = message;


    }


    public void send(Validator validator, SMSDelivery sender) {
        if (validator.validate(recipient.number(), title, message)) {
            sender.send(recipient.number(), title, message);
        } else {
            throw new IllegalArgumentException(String.format("The provided message '%s', '%s', '%s' is not valid", recipient.name(), title, message));
        }
    }
}
