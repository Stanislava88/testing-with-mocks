package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface Validator {
    boolean validate(String number, String title, String message);


}
