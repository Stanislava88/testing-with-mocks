package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public interface PersonDatabase {
    void addPersonToDataBase(Person person);

    Person getByName(String name);
}
