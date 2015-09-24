package smsgateway;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class GateWayTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    @Mock
    SmsReceiver receiver;
    @Mock
    SmsValidation validation;

    @Test
    public void happyPath() {
        final Sms sms = new Sms("mesage", "telephoneNumber", "heading");
        GateWay gateWay = new GateWay(receiver, validation);
        context.checking(new Expectations() {{
            oneOf(validation).validate(sms);
            will(returnValue(true));
            oneOf(receiver).receive(sms);
            will(returnValue(true));
        }});
        gateWay.send(sms);
    }

    @Test
    public void sendSmsWithoutMessage() {
        final Sms sms = new Sms("", "telephoneNumber", "heading");
        GateWay gateWay = new GateWay(receiver, validation);
        context.checking(new Expectations() {{
            oneOf(validation).validate(sms);
            will(returnValue(false));

            never(receiver).receive(sms);
        }});
        gateWay.send(sms);
    }

    @Test
    public void sendSmsWithoutHeading() {
        final Sms sms = new Sms("mesage", "telephoneNumber", "");
        GateWay gateWay = new GateWay(receiver, validation);
        context.checking(new Expectations() {{
            oneOf(validation).validate(sms);
            will(returnValue(false));

            never(receiver).receive(sms);
        }});
        gateWay.send(sms);
    }

    @Test
    public void sendSmsWithoutTelephoneNumber() {
        final Sms sms = new Sms("mesage", "", "heading");
        GateWay gateWay = new GateWay(receiver, validation);
        context.checking(new Expectations() {{
            oneOf(validation).validate(sms);
            will(returnValue(false));

            never(receiver).receive(sms);
        }});
        gateWay.send(sms);
    }

    @Test
    public void sendSmsWithMoreThanOneHundredTwentySymbols() {
        final Sms sms = new Sms("12345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345123451234512345", "telephoneNumber", "heading");
        GateWay gateWay=new GateWay(receiver,validation);
        context.checking(new Expectations() {{
            oneOf(validation).validate(sms);
            will(returnValue(false));

            never(receiver).receive(sms);
        }});
        gateWay.send(sms);
    }
}