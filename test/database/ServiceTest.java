package database;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ServiceTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();


    @Mock
    AgeValidator validator;
    @Mock
    PeopleDatabase personDatabase;


    @Test
    public void successfullyAddPersonToDatabase() {

        final Person john = new Person("John", "42");

        context.checking(new Expectations() {{
            oneOf(personDatabase).add(validator, john);
            will(returnValue(true));
        }});
        assertThat(john.addToDatabase(validator, personDatabase), is(equalTo(true)));
    }


    @Test
    public void tryToAddTooOldPersonToDatabase() {
        final Person bob = new Person("Bob", "101");

        context.checking(new Expectations() {{
            oneOf(personDatabase).add(validator, bob);
        }});

        assertThat(bob.addToDatabase(validator, personDatabase), is(equalTo(false)));
    }

    @Test
    public void tryToAddTooYoungPersonToDatabase() {
        final Person billy = new Person("Billy", "8");

        context.checking(new Expectations() {{
            oneOf(personDatabase).add(validator, billy);
        }});
        assertThat(billy.addToDatabase(validator, personDatabase), is(equalTo(false)));
    }


}
