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
    public void ageInBoundaries() {
        final Person person = new Person("John Smith", "30");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageLowerThanLowerLimit() {
        final Person person = new Person("Christiano Ronaldo Jr.", "9");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageHigherThanHigherLimit() {
        final Person person = new Person("Santa Claus", "2500");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageEqualToHigherLimit() {
        final Person person = new Person("Lili Ivanova", "100");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }

    @Test
    public void ageEqualToLowerLimit(){
        final Person person = new Person("Stuart Little", "10");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).addPersonToDataBase(person);
        }});
        peopleRegisterService.register(person);
    }


    @Test
    public void emptyAge() {
        final Person person = new Person("John Doe", "");
        final PeopleRegisterService peopleRegisterService = new PeopleRegisterService(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
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
            oneOf(ageValidator).isAdult(person.age);
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
    public void ageEqualToEighteen(){
        final Person person = new Person("Chivas Regal", "18");
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
    public void ageLowerThanEighteen() {
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
    public void emptyName() {
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
    public void bothNameAndAgeAreEmpty() {
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
