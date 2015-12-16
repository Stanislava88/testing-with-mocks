package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface AgeValidator {

    boolean acceptable(String age);

    boolean capableOfVoting(String age);
}
