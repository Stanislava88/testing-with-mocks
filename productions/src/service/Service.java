package service;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public class Service {
    private Validator validator;
    private DataStore dataStore;

    public Service(Validator validator, DataStore dataStore) {
        this.validator = validator;
        this.dataStore = dataStore;
    }

    public void addPersonToDatabaseIfAgeIsValid(String name, String age) {
        if (validator.validate(age)) {
            dataStore.addInData(name, age);
        }
    }

    public String getPersonAgeFromDatabase(String name) {
        return dataStore.getByName(name);
    }
}