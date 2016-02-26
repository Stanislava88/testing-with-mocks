package com.clouway.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserAgeValidatorTest {
    private AgeValidator validator = new UserAgeValidator(10, 100);

    @Test
    public void happyPath() throws Exception {
        User user = new User("Ivan", "20");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(true));
    }

    @Test
    public void validateOldUser() throws Exception {
        User user = new User("Maria", "120");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateCharacter() throws Exception {
        User user = new User("Maria", "ccc");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateEmptyAge() throws Exception {
        User user = new User("Lilia", "");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void validateNullAge() throws Exception {
        User user = new User("Lilia", null);

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }
}
