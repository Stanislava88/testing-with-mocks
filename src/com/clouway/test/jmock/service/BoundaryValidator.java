package com.clouway.test.jmock.service;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 10/13/15.
 */
public class BoundaryValidator implements Validator {

    private int lower;
    private int higher;

    public BoundaryValidator(int lower, int higher) {
        this.lower = lower;
        this.higher = higher;
    }

    public boolean isValid(String age) {
        if (Integer.parseInt(age) < lower || Integer.parseInt(age) > higher) {
            return false;
        }
        return true;
    }
}
