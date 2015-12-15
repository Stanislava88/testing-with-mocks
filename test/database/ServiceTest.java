package database;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ServiceTest {
    Service service = null;
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();


    @Mock
    PeopleDatabase personDatabase;

    @Before
    public void setUp() {
        service = new Service(personDatabase);
    }

    @Test
    public void successfullyAddPersonToDatabase() {

        Person john = new Person("John", "42");

        context.checking(new Expectations() {{

            oneOf(personDatabase).acceptable(john);
            will(returnValue(true));
            oneOf(personDatabase).add(john);
            will(returnValue(true));
        }});
        assertThat(service.addToDatabase(john), is(equalTo(true)));
    }

    @Test
    public void successfullyCheckThatPersonIsCapableOfVoting() {

        context.checking(new Expectations() {{
            oneOf(personDatabase).capableOfVoting("john");
            will(returnValue(true));
        }});

        assertThat(service.capableOfVoting("john"), is(equalTo(true)));
    }

    @Test
    public void tryToAddTooOldPersonToDatabase() {
        Person bob = new Person("Bob", "101");

        context.checking(new Expectations() {{
            oneOf(personDatabase).acceptable(bob);
            will(returnValue(false));
            never(personDatabase).add(bob);
        }});

        assertThat(service.addToDatabase(bob), is(equalTo(false)));
    }

    @Test
    public void tryToAddTooYoungPersonToDatabase() {
        Person billy = new Person("Billy", "8");

        context.checking(new Expectations() {{
            oneOf(personDatabase).acceptable(billy);
            will(returnValue(false));
            never(personDatabase).add(billy);
        }});
        assertThat(service.addToDatabase(billy), is(equalTo(false)));
    }


    @Test
    public void successfullyCheckThatPersonIsTooYoungtoVote() {
        context.checking(new Expectations() {{
            oneOf(personDatabase).capableOfVoting("Billy");
            will(returnValue(false));

        }});
        assertThat(service.capableOfVoting("Billy"), is(equalTo(false)));
    }

}
