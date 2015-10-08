package com.clouway.Service;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by clouway on 15-9-30.
 */
public class PeopleRegisterServiceTest {
    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Mock
    PersonDatabase personDatabase;
    @Mock
    AgeValidator ageValidator;

    @Test
    public void happyPath() {
        final Person person = new Person("John Smith", "30");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isValid(person.age);
            will(returnValue(true));
            oneOf(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageUnder10() {
        final Person person = new Person("Christiano Ronaldo Jr.", "5");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isValid(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageOver100() {
        final Person person = new Person("Santa Claus", "2500");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isValid(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageIsEmpty() {
        final Person person = new Person("John Doe", "");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isValid(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageIsNull() {
        final Person person = new Person("Uknown", null);
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isValid(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void getAgeHappyPath() {
        final Person person = new Person("Kristiyan Petkov", "24");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(personDatabase).getByName(person.name);
            will(returnValue(person));
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
        }});
        peopleRegisterService.isAdult(person);
    }

    @Test
    public void personIsUnder18() {
        final Person person = new Person("Christiano Ronaldo Jr", "5");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(personDatabase).getByName(person.name);
            will(returnValue(person));
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
        }});
        peopleRegisterService.isAdult(person);
    }

    @Test
    public void emptyPersonName() {
        final Person person = new Person("", "23");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(personDatabase).getByName(person.name);
            will(returnValue(person));
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));

        }});
        peopleRegisterService.isAdult(person);

    }

    @Test
    public void emptyPersonAge() {
        final Person person = new Person("John", "");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(personDatabase).getByName(person.name);
            will(returnValue(person));
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
        }});
        peopleRegisterService.isAdult(person);
    }

    @Test
    public void bothPersonNameAndPersonAgeAreEmpty() {
        final Person person = new Person("", "");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(personDatabase).getByName(person.name);
            will(returnValue(person));
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
        }});
        peopleRegisterService.isAdult(person);
    }

    @Test
    public void personIsNull() {
        final Person person = null;
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        assertEquals(false, peopleRegisterService.isAdult(person));
    }


}
