package com.clouway.message;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class MessageDispatcher {
    private final MessageGateway gateway;
    private final Validator validator;

    public MessageDispatcher(MessageGateway gateway, Validator validator) {
        this.gateway = gateway;
        this.validator = validator;
    }

    public void send(Message message) {
        if (validator.isValid(message)) {
            gateway.send(message);
        }
    }
}