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
public class ServiceTest {
    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Mock
    DataBase dataBase;
    @Mock
    Validator validator;

    @Test
    public void happyPath() {
        final Person person = new Person("John Smith", "30");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(validator).validateIfAgeIsOver10AndUnder100(person.age);
            will(returnValue(true));
            oneOf(dataBase).addPersonToDataBase(person);
        }});
        service.checkIfPersonIsSuitableToBeAddedInDataBase(person);
    }

    @Test
    public void testWhatHappensIfAgeIsUnder10() {
        final Person person = new Person("Christiano Ronaldo Jr.", "5");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(validator).validateIfAgeIsOver10AndUnder100(person.age);
            will(returnValue(false));
            never(dataBase).addPersonToDataBase(person);
        }});
        service.checkIfPersonIsSuitableToBeAddedInDataBase(person);
    }

    @Test
    public void testWhatHappensIfAgeIsOver100() {
        final Person person = new Person("Santa Claus", "2500");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(validator).validateIfAgeIsOver10AndUnder100(person.age);
            will(returnValue(false));
            never(dataBase).addPersonToDataBase(person);
        }});
        service.checkIfPersonIsSuitableToBeAddedInDataBase(person);
    }

    @Test
    public void testWhatHappensIfAgeIsEmpty() {
        final Person person = new Person("John Doe", "");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(validator).validateIfAgeIsOver10AndUnder100(person.age);
            will(returnValue(false));
            never(dataBase).addPersonToDataBase(person);
        }});
        service.checkIfPersonIsSuitableToBeAddedInDataBase(person);
    }

    @Test
    public void testWhatHappensIfAgeIsNull() {
        final Person person = new Person("Uknown", null);
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(validator).validateIfAgeIsOver10AndUnder100(person.age);
            will(returnValue(false));
            never(dataBase).addPersonToDataBase(person);
        }});
        service.checkIfPersonIsSuitableToBeAddedInDataBase(person);
    }

    @Test
    public void getAgeHappyPath() {
        final Person person = new Person("Kristiyan Petkov", "24");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(dataBase).getByName(person.name);
            will(returnValue(person));
            oneOf(validator).validateIfAgeIsOver18(person.age);
            will(returnValue(true));
        }});
        service.checkIfAgeIsUnderOrOver18Years(person);
    }

    @Test
    public void testWhatHappensIfPersonIsUnder18() {
        final Person person = new Person("Christiano Ronaldo Jr", "5");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(dataBase).getByName(person.name);
            will(returnValue(person));
            oneOf(validator).validateIfAgeIsOver18(person.age);
            will(returnValue(false));
        }});
        service.checkIfAgeIsUnderOrOver18Years(person);
    }

    @Test
    public void testWhatHappensIfPersonNameIsEmpty() {
        final Person person = new Person("", "23");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(dataBase).getByName(person.name);
            will(returnValue(person));
            oneOf(validator).validateIfAgeIsOver18(person.age);
            will(returnValue(false));

        }});
        service.checkIfAgeIsUnderOrOver18Years(person);

    }

    @Test
    public void testWhatHappensIfPersonAgeIsEmpty() {
        final Person person = new Person("John", "");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(dataBase).getByName(person.name);
            will(returnValue(person));
            oneOf(validator).validateIfAgeIsOver18(person.age);
            will(returnValue(false));
        }});
        service.checkIfAgeIsUnderOrOver18Years(person);
    }

    @Test
    public void testWhatHappensIfBothPersonAndAgeAreEmpty() {
        final Person person = new Person("", "");
        final Service service = new Service(validator, dataBase);
        mockery.checking(new Expectations() {{
            oneOf(dataBase).getByName(person.name);
            will(returnValue(person));
            oneOf(validator).validateIfAgeIsOver18(person.age);
            will(returnValue(false));
        }});
        service.checkIfAgeIsUnderOrOver18Years(person);
    }

    @Test
    public void testWhatHappensIfPersonIsNull() {
        final Person person = null;
        final Service service = new Service(validator, dataBase);
        assertEquals(false, service.checkIfAgeIsUnderOrOver18Years(person));
    }


}
