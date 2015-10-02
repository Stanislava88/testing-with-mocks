package com.clouway.Service;

/**
 * Created by clouway on 15-9-30.
 */
public interface DataBase {
    void addPersonToDataBase(Person person);

    Person getByName(String name);
}
