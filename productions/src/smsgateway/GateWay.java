package smsgateway;

/**
 * Created by clouway on 15-8-25.
 */
public class GateWay {
    private SmsReceiver receiver;
    private SmsValidation validation;

    public GateWay(SmsReceiver receiver, SmsValidation validation) {
        this.receiver = receiver;
        this.validation = validation;
    }

    public void send(Sms sms) {
        if (validation.validate(sms)){
            receiver.receive(sms);
        }
    }
}
