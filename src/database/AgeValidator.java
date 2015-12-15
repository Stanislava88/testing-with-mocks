package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public interface AgeValidator {


    boolean validateForAdding(String age);

    boolean validateForVoting(String age);
}
