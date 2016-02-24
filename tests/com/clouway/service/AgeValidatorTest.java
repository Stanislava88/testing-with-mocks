package com.clouway.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class AgeValidatorTest {
    private Validator validator = new AgeValidator();

    @Test
    public void happyPath() throws Exception {
        User user = new User("Ivan", "20");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(true));
    }

    @Test
    public void detectedIsInvalidAge() throws Exception {
        User user = new User("Maria", "120");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void detectedIsAgeProvidedAsChar() throws Exception {
        User user = new User("Maria", "ccc");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }

    @Test
    public void detectedIsEmptyAge() throws Exception {
        User user = new User("Lilia", "");

        boolean result = validator.isValid(user.age);

        assertThat(result, is(false));
    }
}
