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
    public void tryToRegisterValidUser() throws Exception {

        final BoundaryValidator boundaryValidator = new BoundaryValidator(10,100);
        final DatabaseService databaseService = new DatabaseService(boundaryValidator, service);
        final User user = new User("Ivan", "12");

        context.checking(new Expectations() {
            {
                oneOf(boundaryValidator).isValid(user.age);
                will(returnValue(true));
                oneOf(service).register(user);
            }
        });
        databaseService.register(user);
    }

    @Test
    public void tryToRegisterNoAdultUser() throws Exception {

        final BoundaryValidator boundaryValidator = new BoundaryValidator(10,100);
        final DatabaseService databaseService = new DatabaseService(boundaryValidator, service);
        final User user = new User("Ivan", "9");

        context.checking(new Expectations() {
            {
                oneOf(boundaryValidator).isValid(user.age);
                will(returnValue(false));
                never(service).registerUser(user);
            }
        });
        databaseService.register(user);
    }

    @Test
    public void tryToRegisterUserWithAgeOverThanAllowed() throws Exception {

        final BoundaryValidator boundaryValidator = new BoundaryValidator(10,100);
        final DatabaseService databaseService = new DatabaseService(boundaryValidator, service);
        final User user = new User("Bai Georgi", "102");

        context.checking(new Expectations() {
            {
                oneOf(boundaryValidator).isValid(user.age);
                will(returnValue(false));
                never(service).register(user);
            }
        });
        databaseService.register(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tryToRegisterNullUserToDatabase() throws Exception {

        final BoundaryValidator boundaryValidator = new BoundaryValidator(10,100);
        final DatabaseService databaseService = new DatabaseService(boundaryValidator, service);
        final User user = new User(null, "18");

        context.checking(new Expectations() {
            {
                oneOf(boundaryValidator).isValid(user.age);
                will(throwException(new IllegalArgumentException("Null user is try to register into database cannot register null user.")));
                never(service).register(user);
            }
        });
        databaseService.register(user);
    }

    @Test(expected = EmptyUserException.class)
    public void tryToRegisterUserWithEmptyFields() throws Exception {

        final BoundaryValidator boundaryValidator = new BoundaryValidator(10,100);
        final DatabaseService databaseService = new DatabaseService(boundaryValidator, service);
        final User user = new User("", "");

        context.checking(new Expectations() {
            {
                oneOf(boundaryValidator).isValid(user.age);
                will(throwException(new EmptyUserException("Try to register user with empty fields.")));
                never(service).register(user);
            }
        });
        databaseService.register(user);
    }
}
