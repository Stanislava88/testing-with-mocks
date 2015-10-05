package com.clouway.test.jmock.sms;

import java.util.Random;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class RandomMessageGenerator {

    final Random rnd = new Random();

    /**
     * @param allowedMessageSymbols is allowed symbol which we generate message.
     * @param length                is a length of message.
     * @return message with length which we set.
     */
    public String generateMessage(String allowedMessageSymbols, int length) {

        StringBuilder stringBuilder = new StringBuilder(length);


        for (int i = 0; i < length; i++) {
            stringBuilder.append(allowedMessageSymbols.charAt(rnd.nextInt(allowedMessageSymbols.length())));
        }

        return stringBuilder.toString();
    }
}
