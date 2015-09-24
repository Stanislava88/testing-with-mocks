package service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


import static junit.framework.Assert.assertSame;

/**
 * Created by clouway on 15-8-25.
 */
public class ServiceTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    Validator validator;
    @Mock
    DataStore dataStore;

    @Test
    public void addHappyPath() {
        final Service service = new Service(validator, dataStore);
        context.checking(new Expectations() {{
            oneOf(validator).validate("20");
            will(returnValue(true));
            oneOf(dataStore).addInData("ivan", "20");
        }});
        service.addPersonToDatabaseIfAgeIsValid("ivan", "20");
    }

    @Test
    public void addLessThenNeed() {
        final Service service = new Service(validator, dataStore);
        context.checking(new Expectations() {{
            oneOf(validator).validate("9");
            will(returnValue(false));
            never(dataStore).addInData("ivan", "9");
        }});
        service.addPersonToDatabaseIfAgeIsValid("ivan", "9");
    }

    @Test
    public void addMorThenNeed() {
        final Service service = new Service(validator, dataStore);
        context.checking(new Expectations() {{
            oneOf(validator).validate("101");
            will(returnValue(false));
            never(dataStore).addInData("ivan", "101");
        }});
        service.addPersonToDatabaseIfAgeIsValid("ivan", "101");
    }

    @Test
    public void getFromData() {
        final Service service = new Service(validator, dataStore);
        context.checking(new Expectations() {{
            oneOf(dataStore).getByName("ivan");
            will(returnValue("20"));
        }});
        assertSame("have to be 20", "20", service.getPersonAgeFromDatabase("ivan"));
    }

    @Test
    public void getFromData1() {
        final Service service = new Service(validator, dataStore);
        context.checking(new Expectations() {{
            oneOf(dataStore).getByName("nikola");
            will(returnValue(null));
        }});
        assertSame("have to be 20", null, service.getPersonAgeFromDatabase("nikola"));
    }
}