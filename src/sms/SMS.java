package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class SMS {
    private SMSDelivery sender;
    private Validator validator;

    public SMS(SMSDelivery sender, Validator validator) {

        this.sender = sender;
        this.validator = validator;
    }

    public boolean received() {

        return sender.received();
    }

    public void send(Recipient recipient, String title, String message) throws InvalidSMSException {
        if (validator.validate(recipient, title, message)) {
            sender.send(recipient, title, message);
        }
    }
}
