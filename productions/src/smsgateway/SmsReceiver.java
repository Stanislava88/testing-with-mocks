package smsgateway;

/**
 * Created by clouway on 15-8-25.
 */
public interface SmsReceiver {
    boolean receive(Sms sms);
}
