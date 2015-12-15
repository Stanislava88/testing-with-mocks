package sms;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@RunWith(Parameterized.class)
public class MessageRangeTest {
    MessageRange messageRange= null;

    @Before
    public void setUp(){
        messageRange= new MessageRange(min, max);
    }

    @After
    public void tearDown(){
        messageRange= null;
    }

    public MessageRangeTest(int min, int max, int valueIn, int valueOut) {
        this.min = min;
        this.max = max;
        this.valueIn = valueIn;
        this.valueOut = valueOut;
    }

    @Parameters
    public static Collection<Object[]> rangeAndValues(){
        return Arrays.asList(new Object[][]{
                {1, 120, 3, 123},{10, 14, 13, 4}, {13, 120, 23, 12}
        });
    }

    private int min;
    private int max;
    private int valueIn;
    private int valueOut;

    @Test
    public void valueWithinLimits(){
        assertThat(messageRange.isBetweenRange(valueIn), is(equalTo(true)));
    }

    @Test
    public void valueOutsideLimits(){
        assertThat(messageRange.isBetweenRange(valueOut), is(equalTo(false)));
    }

}
