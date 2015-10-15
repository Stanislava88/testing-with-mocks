package com.clouway.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by clouway on 15-10-12.
 */
public class BoundaryAgeValidatorTest {
    @Test
    public void happyPath(){
        final Person person = new Person("Unknown","20");
       final BoundaryAgeValidator bulgarianAgeValidator = new BoundaryAgeValidator(18,80);
        assertEquals(true,bulgarianAgeValidator.isAdult(person.age));
    }

    @Test
    public void ageLowerThanLowerBoundary(){
        final Person person = new Person("Unknown","6");
        final BoundaryAgeValidator bulgarianAgeValidator = new BoundaryAgeValidator(18,80);
        assertEquals(false,bulgarianAgeValidator.isAdult(person.age));
    }

    @Test
    public void ageHigherThanHigherBoundary(){
        final Person person = new Person("Unknown","90");
        final BoundaryAgeValidator bulgarianAgeValidator = new BoundaryAgeValidator(18,80);
        assertEquals(false,bulgarianAgeValidator.isAdult(person.age));
    }

    @Test
    public void ageEqualToLowerBoundary(){
        final Person person = new Person("Unknown","18");
        final BoundaryAgeValidator bulgarianAgeValidator = new BoundaryAgeValidator(18,80);
        assertEquals(true,bulgarianAgeValidator.isAdult(person.age));
    }

    @Test
    public void ageEqualToHigherBoundary(){
        final Person person = new Person("Unknown","80");
        final BoundaryAgeValidator bulgarianAgeValidator = new BoundaryAgeValidator(18,80);
        assertEquals(true,bulgarianAgeValidator.isAdult(person.age));
    }
}