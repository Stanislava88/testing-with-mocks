package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public class Service {
    private final DataBase dataBase;
    private final Validator validator;

    public Service(Validator validator, DataBase dataBase) {
        this.validator = validator;
        this.dataBase = dataBase;
    }

    public void checkIfPersonIsSuitableToBeAddedInDataBase(Person person) {
        if (validator.validateIfAgeIsOver10AndUnder100(person.age)) {
            dataBase.addPersonToDataBase(person);
        }
    }

    public boolean checkIfAgeIsUnderOrOver18Years(Person person) {
        if (person == null) {
            return false;
        } else {
            return validator.validateIfAgeIsOver18(dataBase.getByName(person.name).age);
        }
    }
}
