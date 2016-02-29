package com.clouway.service;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserServiceTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private UserRepository database = context.mock(UserRepository.class);
    private AgeValidator validator = context.mock(AgeValidator.class);

    private UserService service = new UserService(database, validator);

    @Test
    public void registerUser() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(user.age);
            will(returnValue(true));

            oneOf(database).save(user);
        }});

        service.register(user);
    }

    @Test
    public void registerOldUser() throws Exception {
        final User user = new User("Ivan", "120");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(user.age);
            will(returnValue(false));

            never(database).save(user);
        }});

        service.register(user);
    }

    @Test
    public void registerYoungUser() throws Exception {
        final User user = new User("Ivan", "5");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(user.age);
            will(returnValue(false));
        }});

        service.register(user);
    }

    @Test
    public void isAdultUser() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            oneOf(database).findByName(user.name);
            will(returnValue(user));
        }});

        int adultAge = 18;
        boolean isAdult = service.isAdult("Ivan", adultAge);

        assertTrue(isAdult);
    }

    @Test
    public void isAdultMinorUser() throws Exception {
        final String name = "Maria";
        final User user = new User(name, "12");

        context.checking(new Expectations() {{
            oneOf(database).findByName(name);
            will(returnValue(user));
        }});

        int adultAge = 18;
        boolean isAdult = service.isAdult("Maria", adultAge);

        assertFalse(isAdult);
    }

    @Test
    public void isAdultUndefinedUser() throws Exception {
        context.checking(new Expectations() {{
            oneOf(database).findByName("Lilia");
            will(returnValue(null));
        }});

        int adultAge = 18;
        boolean isAdult = service.isAdult("Lilia", adultAge);

        assertFalse(isAdult);
    }
}

