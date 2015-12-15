package database;

import java.util.Optional;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface PeopleDatabase {
    boolean add(Person person);

    boolean acceptable(Person person);

    boolean capableOfVoting(String name);
}
