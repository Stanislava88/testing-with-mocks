package sms;

import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import org.jmock.Expectations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

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

    @Test
    public void successfullySendSMS() throws InvalidSMSException {

        SMS sms = new SMS(sender, validator);
        Recipient recipient = new Recipient("John", "0878125246");
        String title = "we have to meet";
        String message = "you forgot your wallet the other day";

        context.checking(new Expectations() {{
            oneOf(validator).validate(recipient, title, message);
            will(returnValue(true));
            oneOf(sender).send(recipient, title, message);
            oneOf(sender).received();
            will(returnValue(true));
        }});

        sms.send(recipient, title, message);
        assertThat(sms.received(), is(equalTo(true)));
    }

    @Test
    public void InvalidSMSThrowsException() throws InvalidSMSException {
        SMS sms = new SMS(sender, validator);
        Recipient recipient = new Recipient("Bill", "");
        String title = "title";
        String message = "message";
        context.checking(new Expectations() {{
            oneOf(validator).validate(recipient, title, message);
            will(throwException(new InvalidSMSException("Invalid recipient number")));
        }});
        try {
            sms.send(recipient, title, message);
        } catch (InvalidSMSException ex) {
            assertThat("Invalid recipient number", is(equalTo(ex.getMessage())));
        }
    }

}
