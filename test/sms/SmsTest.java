package sms;

import org.jmock.Expectations;
import org.jmock.Sequence;
import org.jmock.auto.Auto;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class SmsTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    @Mock
    SMSDelivery sender;
    @Mock
    Validator validator;
    @Auto
    Sequence smsInvocations;

    @Test
    public void successfullySendSMS() {


        Recipient recipient = new Recipient("John", "0878125246");
        String title = "we have to meet";
        String message = "you forgot your wallet the other day";
        SMSMessage sms = new SMSMessage(recipient, title, message);

        context.checking(new Expectations() {{
            oneOf(validator).validate(recipient.number(), title, message);
            will(returnValue(true));
            inSequence(smsInvocations);
            oneOf(sender).send(recipient.number(), title, message);
            will(returnValue(true));
            inSequence(smsInvocations);
        }});

        sms.send(validator, sender);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidTitleNeverSend() {
        Recipient recipient = new Recipient("Bill", "1234567890");
        String title = "";
        String message = "message";
        SMSMessage sms = new SMSMessage(recipient, title, message);

        context.checking(new Expectations() {{
            oneOf(validator).validate(recipient.number(), title, message);
            will(returnValue(false));
            never(sender).send(recipient.number(), title, message);
        }});

        sms.send(validator, sender);

    }

}
