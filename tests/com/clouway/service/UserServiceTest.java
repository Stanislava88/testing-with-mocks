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

    private Database database = context.mock(Database.class);
    private AgeValidator validator = context.mock(AgeValidator.class);

    private UserService service = new UserService(database, validator);

    @Test
    public void happyPath() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            oneOf(validator).isAgeValid(user.age);
            will(returnValue(true));

            oneOf(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void noRegisterInvalidUser() throws Exception {
        final User user = new User("Ivan", "120");

        context.checking(new Expectations() {{
            oneOf(validator).isAgeValid(user.age);
            will(returnValue(false));

            never(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void checkAdultUser() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            oneOf(database).findUser(user.name);
            will(returnValue(user));

            oneOf(validator).isAgeAdult(user.age);
            will(returnValue(true));
        }});
        boolean result = service.isAdult("Ivan");

        assertThat(result, is(true));
    }

    @Test
    public void checkNoAdultUser() throws Exception {
        final String name="Maria";
        final User user = new User(name, "11");

        context.checking(new Expectations() {{
            oneOf(database).findUser(name);
            will(returnValue(user));

            oneOf(validator).isAgeAdult(user.age);
            will(returnValue(false));
        }});
        boolean result = service.isAdult("Maria");

        assertThat(result,is((false)));
    }
}

