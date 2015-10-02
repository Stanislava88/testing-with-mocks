package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public class Service {
    private final PersonDatabase personDatabase;
    private final Validator validator;

    public Service(Validator validator, PersonDatabase personDatabase) {
        this.validator = validator;
        this.personDatabase = personDatabase;
    }

    public void checkIfPersonIsSuitableToBeAddedInDataBase(Person person) {
        if (validator.validateIfAgeIsOver10AndUnder100(person.age)) {
            personDatabase.addPersonToDataBase(person);
        }
    }

    public boolean checkIfAgeIsUnderOrOver18Years(Person person) {
        if (person == null) {
            return false;
        } else {
            return validator.validateIfAgeIsOver18(personDatabase.getByName(person.name).age);
        }
    }
}
