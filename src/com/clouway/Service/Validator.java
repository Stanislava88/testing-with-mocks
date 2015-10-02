package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public interface Validator {
    boolean validateIfAgeIsOver10AndUnder100(String age);

    boolean validateIfAgeIsOver18(String age);

}
