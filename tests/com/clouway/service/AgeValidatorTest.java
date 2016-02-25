package com.clouway.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class AgeValidatorTest {
    private AgeValidator validator = new UserAgeValidator(10, 100);

    @Test
    public void happyPath() throws Exception {
        User user = new User("Ivan", "20");

        boolean result = validator.isAgeValid(user.age);

        assertThat(result, is(true));
    }

    @Test
    public void validateInvalidAge() throws Exception {
        User user = new User("Maria", "120");

        boolean result = validator.isAgeValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateAgeAsChar() throws Exception {
        User user = new User("Maria", "ccc");

        boolean result = validator.isAgeValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateEmptyAge() throws Exception {
        User user = new User("Lilia", "");

        boolean result = validator.isAgeValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateAdultUser() throws Exception {
        AgeValidator validator = new UserAgeValidator(1, 18);
        User user = new User("Ivan", "20");

        boolean result=validator.isAgeAdult(user.age);

        assertThat(result,is(true));
    }

    @Test
    public void validateNoAdultUser() throws Exception {
        AgeValidator validator = new UserAgeValidator(1, 18);
        User user = new User("Ivan", "9");

        boolean result=validator.isAgeAdult(user.age);

        assertThat(result,is(false));
    }
}
