package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface PeopleDatabase {

    boolean add(Person person);


    boolean capableOfVoting(String name);
}
