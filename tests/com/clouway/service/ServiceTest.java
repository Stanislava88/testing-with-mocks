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
    private AgeValidator validator = context.mock(AgeValidator.class);

    @Test
    public void happyPath() throws Exception {
        final User user = new User("Ivan", "20");
        UserService service = new UserService(user, database, validator);

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
        UserService service = new UserService(user, database, validator);

        context.checking(new Expectations() {{
            oneOf(validator).isAgeValid(user.age);
            will(returnValue(false));

            never(database).save(user);
        }});
        service.register(user);
    }

    @Test
    public void checkIsAdultUser() throws Exception {
        final User user = new User("Ivan", "20");
        UserService service = new UserService(user,database, validator);

        context.checking(new Expectations() {{
            oneOf(database).isUserDB(user.name);
            will(returnValue(true));

            oneOf(validator).isAgeAdult(user.age);
            will(returnValue(true));
        }});
        boolean result = service.isAdult("Ivan");

        assertThat(result, is(true));
    }
}

