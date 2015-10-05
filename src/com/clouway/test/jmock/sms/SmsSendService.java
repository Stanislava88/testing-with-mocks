package com.clouway.test.jmock.sms;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class SmsSendService {
    private Gateway gateway;
    private Validator validator;

    /**
     *
     * @param gateway is a communication serice  which send message to recepient.
     * @param validator validate message before we send it.
     */
    public SmsSendService(Gateway gateway, Validator validator) {
        this.gateway = gateway;
        this.validator = validator;
    }

    /**
     *
     * @param sms is message which we send.
     */
    public void sendSMS(SMS sms) {
        if (validator.isValid(sms)) {
            gateway.sendSMS(sms);
        }
    }

}
