package database;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class PeopleAgeValidatorTest {
    AgeValidator validator = null;

    @Before
    public void setUp() {
        validator = new PeopleAgeValidator(18, 10, 100);
    }


    @Test
    public void successfullyValidatePersonsAgeIsAcceptable() {
        assertThat(validator.acceptable("12"), is(equalTo(true)));
    }

    @Test
    public void confirmSomeoneIsCapableOfVoting() {
        assertThat(validator.capableOfVoting("18"), is(equalTo(true)));
    }

    @Test
    public void personIsTooOld() {
        assertThat(validator.acceptable("101"), is(equalTo(false)));
    }

    @Test
    public void personIsTooYoung() {
        assertThat(validator.acceptable("9"), is(equalTo(false)));
    }

    @Test
    public void personIsNotOldEnoughToVote() {
        assertThat(validator.capableOfVoting("17"), is(equalTo(false)));
    }
}
