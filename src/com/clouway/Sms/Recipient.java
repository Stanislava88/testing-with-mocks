package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public class Recipient {
    private final String phoneNumber;

    public Recipient(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
