package com.clouway.service;

/**
 * Created by clouway on 15-10-12.
 */
public class BoundaryAgeValidator implements AgeValidator {


    private int lowerAge;
    private int higherAge;

    public BoundaryAgeValidator(int lowerAge, int higherAge) {
        this.lowerAge = lowerAge;
        this.higherAge = higherAge;
    }

    @Override
    public boolean isAdult(String age) {
        int ageInt= Integer.parseInt(age);
        if(ageInt>=lowerAge && ageInt<=higherAge){
            return true;
        }else{
            return false;
        }
    }
}
