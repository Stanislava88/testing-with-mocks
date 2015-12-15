package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class MessageRange {
    private final int min;
    private final int max;

    public MessageRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isBetweenRange(int number) {
        return min <= number && number <= max;
    }
}
