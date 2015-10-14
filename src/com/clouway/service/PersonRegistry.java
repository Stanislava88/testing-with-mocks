package com.clouway.service;

/**
 * Created by clouway on 15-9-30.
 */
public class PersonRegistry {
    private final PersonDatabase personDatabase;
    private final AgeValidator ageValidator;

    public PersonRegistry(AgeValidator ageValidator, PersonDatabase personDatabase) {
        this.ageValidator = ageValidator;
        this.personDatabase = personDatabase;
    }

    public void register(Person person) {
        if (ageValidator.isAdult(person.age)) {
            personDatabase.register(person);
        }
    }
}
