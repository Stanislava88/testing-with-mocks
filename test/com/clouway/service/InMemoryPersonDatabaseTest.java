package com.clouway.service;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clouway on 15-10-12.
 */
public class InMemoryPersonDatabaseTest {
    @Test
    public void happyPath(){
        final Person person = new Person("Ray","15");
        final InMemoryPersonDatabase inMemoryPersonDatabase = new InMemoryPersonDatabase();
        inMemoryPersonDatabase.register(person);
        assertEquals(person, inMemoryPersonDatabase.getName("Ray"));
    }

    @Test
    public void ageEqualToLowerBoundary(){
        final Person person = new Person("Sam","10");
        final InMemoryPersonDatabase inMemoryPersonDatabase = new InMemoryPersonDatabase();
        inMemoryPersonDatabase.register(person);
        assertEquals(person,inMemoryPersonDatabase.getName("Sam"));
    }

    @Test
    public void ageEqualToHigherBoundary(){
        final Person person = new Person("Hulk","80");
        final InMemoryPersonDatabase inMemoryPersonDatabase = new InMemoryPersonDatabase();
        inMemoryPersonDatabase.register(person);
        assertEquals(person,inMemoryPersonDatabase.getName("Hulk"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void nameDuplication(){
        final Person person = new Person("John", "22");
        final Person person2 = new Person("John","33");
        final InMemoryPersonDatabase inMemoryPersonDatabase = new InMemoryPersonDatabase();
        inMemoryPersonDatabase.register(person);
        inMemoryPersonDatabase.register(person2);
    }

    @Test(expected = NullPointerException.class)
    public void personIsNull(){
        final Person person = null;
        final InMemoryPersonDatabase inMemoryPersonDatabase = new InMemoryPersonDatabase();
        inMemoryPersonDatabase.register(person);
    }
}
