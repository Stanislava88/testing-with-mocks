package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface Validator {
    boolean validate(Recipient recipient, String title, String message) throws InvalidSMSException;


}
