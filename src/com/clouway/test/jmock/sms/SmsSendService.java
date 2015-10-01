package com.clouway.test.jmock.sms;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/30/15
 */
public class SmsSendService {
    private Gateway gateway;
    private Validator validator;

    public SmsSendService(Gateway gateway, Validator validator) {
        this.gateway = gateway;
        this.validator = validator;
    }
    public void sendSMS(SMS sms){
        if(validator.isValid(sms)){
            gateway.sendSMS(sms);
        }
    }
}
