package com.clouway.service;

import com.clouway.test.jmock.service.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class ServiceTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    Service service;

    @Mock
    Validator validator;

    @Test
    public void registerValidUserToDatabase() {

        DatabaseService databaseService = new DatabaseService(service, validator);
        User user = new User("Ivaylo", "24");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(user.age);
                will(returnValue(true));
                oneOf(service).register(user);
            }
        });
        databaseService.register(user);

    }

    @Test
    public void tryToRegisterNoAdultUser() throws Exception {
        DatabaseService databaseService = new DatabaseService(service, validator);
        User user = new User("Ivan", "17");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(user.age);
                will(returnValue(false));
            }
        });
        databaseService.register(user);
    }

    @Test
    public void tryToRegisterUserWithAgeOverThanAllowed() throws Exception {
        DatabaseService databaseService = new DatabaseService(service, validator);
        User user = new User("Bai Georgi", "102");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(user.age);
                will(returnValue(false));

            }
        });
        databaseService.register(user);
    }

    @Test(expected = NullPointerException.class)
    public void tryToRegisterNullUser() throws Exception {

        DatabaseService databaseService = new DatabaseService(service, validator);
        User user = new User(null, "18");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(user.age);
                will(throwException(new NullPointerException()));
            }
        });
        databaseService.register(user);
    }

    @Test(expected = EmptyUserException.class)
    public void tryToRegisterUserWithEmptyFields() throws Exception {
        DatabaseService databaseService = new DatabaseService(service, validator);
        User user = new User("", "");

        context.checking(new Expectations() {
            {
                oneOf(validator).isValid(user.age);
                will(throwException(new EmptyUserException("Empty user try to register,cannot register empty user.")));
            }
        });
        databaseService.register(user);
    }
}
