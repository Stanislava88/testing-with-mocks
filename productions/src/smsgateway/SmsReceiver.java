package smsgateway;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public interface SmsReceiver {
    boolean receive(Sms sms);
}
