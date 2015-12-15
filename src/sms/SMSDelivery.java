package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface SMSDelivery {
    boolean received();

    void send(Recipient recipient, String title, String message);
}
