package com.clouway.test.jmock.message;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class MessageService {

    private Gateway gateway;
    private Validator validator;

    /**
     * @param gateway   is a communication service  which send message to recepient.
     * @param validator validate message before we send it.
     */
    public MessageService(Gateway gateway, Validator validator) {
        this.gateway = gateway;
        this.validator = validator;
    }

    /**
     * @param message is message which we send.
     */
    public void sendMessage(Message message) {
        if (validator.isValidMessage(message)) {
            gateway.sendMessage(message);
        }
    }

}
