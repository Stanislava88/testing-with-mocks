package sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@RunWith(Parameterized.class)
public class RecipientTest {

    public RecipientTest(String number) {
        this.number = number;
    }

    @Parameters
    public static Collection<Object[]> numbers(){
        return Arrays.asList(new Object[][]{
                {""},{"asd"}, {"1234s"}
        });
    }

    private String number;



    @Test(expected = IllegalArgumentException.class)
    public void recipientNumberIncludesCharsDifferentThenNumber(){
        Recipient recipient=new Recipient("Ivaylo", number);

    }

}
