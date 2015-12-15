package sms;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Recipient {
    private final String name;
    private final String number;

    public Recipient(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public int numberLength() {
        return number.length();
    }

    public boolean numberOnlyDigits() {
        return number.matches("[0-9]+");
    }
}
