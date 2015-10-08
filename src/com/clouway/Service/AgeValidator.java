package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public interface AgeValidator {
    boolean isBetween10and100(String age);
    boolean isOver18(String age);
}
