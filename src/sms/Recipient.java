package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Recipient {
    private final String name;
    private final String number;

    public Recipient(String name, String number) {
        this.name = name;
        if (numberOnlyDigits(number)) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("The number is not valid");
        }

    }

    public String name() {
        return name;
    }

    private boolean numberOnlyDigits(String number) {
        return number.matches("[0-9]+");
    }

    public String number() {
        return number;
    }
}
