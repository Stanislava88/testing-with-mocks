package com.clouway.service;

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
public class PersonRegistryTest {
    @Rule
    public JUnitRuleMockery mockery = new JUnitRuleMockery();

    @Mock
    PersonDatabase personDatabase;

    @Mock
    AgeValidator ageValidator;


    @Test
    public void ageInBoundaries() {
        final Person person = new Person("John Smith", "30");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }

    @Test
    public void ageLowerThanLowerLimit() {
        final Person person = new Person("Christiano Ronaldo Jr.", "9");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }

    @Test
    public void ageHigherThanHigherLimit() {
        final Person person = new Person("Santa Claus", "2500");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }

    @Test
    public void ageEqualToHigherLimit() {
        final Person person = new Person("Lili Ivanova", "100");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }

    @Test
    public void ageEqualToLowerLimit(){
        final Person person = new Person("Stuart Little", "10");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(true));
            oneOf(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }


    @Test
    public void emptyAge() {
        final Person person = new Person("John Doe", "");
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }

    @Test
    public void ageIsNull() {
        final Person person = new Person("Uknown", null);
        final PersonRegistry personRegistry = new PersonRegistry(ageValidator, personDatabase);
        mockery.checking(new Expectations() {{
            oneOf(ageValidator).isAdult(person.age);
            will(returnValue(false));
            never(personDatabase).register(person);
        }});
        personRegistry.register(person);
    }
}
