package com.clouway.Sms;

/**
 * Created by clouway on 15-9-25.
 */
public class Reciever {
    private final String phoneNumber;

    public Reciever(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return  phoneNumber;
    }

}
