package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public interface AgeValidator {
    boolean isBetweenLowerAndHigherLimit(String age);
    boolean isOver18(String age);
}
