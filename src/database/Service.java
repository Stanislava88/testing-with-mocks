package database;

import java.util.Optional;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Service {
    private final PeopleDatabase peopleDatabase;

    public Service(PeopleDatabase peopleDatabase) {

        this.peopleDatabase = peopleDatabase;
    }


    public boolean addToDatabase(Person person) {
        return peopleDatabase.acceptable(person) && person.addToDatabase(peopleDatabase);


    }

    public boolean capableOfVoting(String name) {
        return peopleDatabase.capableOfVoting(name);
    }
}
