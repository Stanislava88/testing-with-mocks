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
public class ServiceTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    private Database database = context.mock(Database.class);
    private Validator validator = context.mock(Validator.class);

    UserService service = new UserService(database, validator);

    @Test
    public void happyPath() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(user.age);
            will(returnValue(true));

            oneOf(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void noRegisterInvalidUser() throws Exception {
        final User user = new User("Ivan", "120");

        context.checking(new Expectations() {{
            oneOf(validator).isValid(user.age);
            will(returnValue(false));

            never(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void findUser() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{

            oneOf(database).findUser(user);
        }});

        boolean result = service.find("18", new User("Ivan", "20"));

        assertThat(result, is(true));
    }

    @Test
    public void notFindUser() throws Exception {
        final User user = new User("Ivan", "20");

        context.checking(new Expectations() {{
            never(database).findUser(user);
        }});

        boolean result = service.find("18", new User("Ivan", "13"));

        assertThat(result, is(false));
    }
}

