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
public class InMemoryPeopleDatabaseTest {
    private PeopleDatabase database = null;

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    @Mock
    AgeValidator validator;

    @Before
    public void setUp() {
        database = new InMemoryPeopleDatabase(validator);
    }

    @Test
    public void successfullyAddPersonToDatabase() {

        Person john = new Person("John", "32");
        context.checking(new Expectations() {{
            oneOf(validator).acceptable("32");
            will(returnValue(true));
        }});
        assertThat(database.add(john), is(equalTo(true)));
    }

    @Test
    public void successfullyConfirmSomeoneIsCapableOfVoting() {
        Person bill = new Person("Bill", "28");

        context.checking(new Expectations() {{
            oneOf(validator).acceptable("28");
            will(returnValue(true));
            oneOf(validator).capableOfVoting("28");
            will(returnValue(true));
        }});
        database.add(bill);

        assertThat(database.capableOfVoting("Bill"), is(equalTo(true)));
    }

    @Test
    public void personNotValidatedForAdding() {
        Person janet = new Person("Janet", "101");
        context.checking(new Expectations() {{
            oneOf(validator).acceptable("101");
            will(returnValue(false));
        }});
        assertThat(database.add(janet), is(equalTo(false)));
    }

    @Test
    public void personIsNotCapableOfVoting() {
        Person carly = new Person("Carly", "17");
        context.checking(new Expectations() {{
            oneOf(validator).acceptable("17");
            will(returnValue(true));
            atLeast(1).of(validator).capableOfVoting("17");
            will(returnValue(false));
        }});
        database.add(carly);
        assertThat(database.capableOfVoting("Carly"), is(equalTo(false)));
    }
}
