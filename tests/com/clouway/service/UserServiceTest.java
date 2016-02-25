package com.clouway.service;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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

            never(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void isAdult() throws Exception {
        final User user = new User("Ivan", "20");
        String adultAge = "18";

        context.checking(new Expectations() {{
            oneOf(database).findUser(user.name);
            will(returnValue(user));
        }});
        boolean result = service.isAdult("Ivan", adultAge);

        assertThat(result, is(true));
    }

    @Test
    public void isNotAdult() throws Exception {
        final String name = "Maria";
        String adultAge = "18";
        final User user = new User(name, "11");

        context.checking(new Expectations() {{
            oneOf(database).findUser(name);
            will(returnValue(user));

        }});
        boolean result = service.isAdult("Maria", adultAge);

        assertThat(result, is((false)));
    }
}

