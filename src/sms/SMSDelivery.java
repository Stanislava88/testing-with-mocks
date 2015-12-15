package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface SMSDelivery {

    boolean send(String number, String title, String message);
}
