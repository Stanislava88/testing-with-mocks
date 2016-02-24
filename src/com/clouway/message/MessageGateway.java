package com.clouway.message;

/**
 * This interface represent the external system for sending report
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface MessageGateway {
    /**
     * Send message.
     *
     * @param message{@link com.clouway.message.Message} to be sent
     */
    void send(Message message);
}
