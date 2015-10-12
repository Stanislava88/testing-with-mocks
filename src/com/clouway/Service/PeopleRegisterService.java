package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public class PeopleRegisterService {
    private final PersonDatabase personDatabase;
    private final AgeValidator ageValidator;

    public PeopleRegisterService(AgeValidator ageValidator, PersonDatabase personDatabase) {
        this.ageValidator = ageValidator;
        this.personDatabase = personDatabase;
    }

    public void register(Person person) {
        if (ageValidator.isAdult(person.age)) {
            personDatabase.addPersonToDataBase(person);
        }
    }

    public boolean isAdult(Person person) {
        if (person == null) {
            return false;
        } else {
            return ageValidator.isAdult(personDatabase.getByName(person.name).age);
        }
    }
}
