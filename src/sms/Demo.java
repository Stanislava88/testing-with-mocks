package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Demo {

    public static void main(String[] args) {
        SMSMessage sms = new SMSMessage(new Recipient("sdasd", "123456789"), "", "");

        try {
            sms.send( new SMSValidator(10, new MessageRange(1, 120)),new SMSDelivery() {
                @Override
                public boolean send(String number, String title, String message) {
                    return false;
                }
            });
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
