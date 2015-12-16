package database;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class PeopleAgeValidator implements AgeValidator {
    private final int votingAge;
    private final int addingMin;
    private final int addingMax;

    public PeopleAgeValidator(int votingAge, int addingMin, int addingMax) {
        this.votingAge = votingAge;
        this.addingMin = addingMin;
        this.addingMax = addingMax;
    }

    @Override
    public boolean acceptable(String age) {
        int intAge = Integer.parseInt(age);
        return intAge >= addingMin && intAge <= addingMax;
    }

    @Override
    public boolean capableOfVoting(String age) {
        int intAge = Integer.parseInt(age);
        return intAge >= votingAge;
    }
}
