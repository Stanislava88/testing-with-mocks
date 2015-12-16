package database;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class InMemoryPeopleDatabase implements PeopleDatabase {

    private AgeValidator validator;
    private List<Person> peopleDatabase = new ArrayList<>();


    public InMemoryPeopleDatabase(AgeValidator validator) {
        this.validator = validator;
    }

    @Override
    public boolean add(Person person) {
        if (peopleDatabase.contains(person)) {
            throw new IllegalArgumentException("this person is already in the peopleDatabase");
        }
        if (validator.acceptable(person.age())) {
            peopleDatabase.add(person);
            return peopleDatabase.contains(person);
        }
        return false;
    }

    @Override
    public boolean capableOfVoting(String name) {
        for (Person person : peopleDatabase) {
            if (person.name().equals(name)) {
                return validator.capableOfVoting(person.age());
            }
        }
        return false;
    }
}
