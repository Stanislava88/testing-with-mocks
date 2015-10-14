package com.clouway.service;

/**
 * Created by clouway on 15-9-30.
 */
public interface PersonDatabase {
    void register(Person person);

    Person getName(String name);
}
