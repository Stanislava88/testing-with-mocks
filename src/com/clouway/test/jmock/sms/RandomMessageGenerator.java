package com.clouway.test.jmock.sms;

import java.util.Random;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class RandomMessageGenerator {

    final Random rnd = new Random();

    char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * @param length is a length of message.
     * @return message with length which we set.
     */
    public String generateMessage(final int length) {

        StringBuilder stringBuilder = new StringBuilder(length);


        for (int i = 0; i < length; i++) {

            char c = chars[rnd.nextInt(chars.length)];
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
