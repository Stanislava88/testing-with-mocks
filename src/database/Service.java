package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Service {
    private final AgeValidator validator;
    private final PeopleDatabase peopleDatabase;

    public Service(AgeValidator validator, PeopleDatabase peopleDatabase) {
        this.validator = validator;
        this.peopleDatabase = peopleDatabase;
    }


    public boolean addToDatabase(Person person) {
        return validator.validateForAdding(person.age()) && person.addToDatabase(peopleDatabase);
    }

    public boolean capableOfVoting(String name) {
        return validator.validateForVoting(peopleDatabase.getAge(name));
    }
}
