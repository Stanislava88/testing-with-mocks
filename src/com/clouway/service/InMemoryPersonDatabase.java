package com.clouway.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clouway on 15-10-12.
 */
public class InMemoryPersonDatabase implements PersonDatabase {
    private List<Person> persons = new ArrayList<>();
    @Override
    public void register(Person person) {
        if(person==null){
            throw  new NullPointerException("Person is null!");
        }else {
            for (Person p : persons) {
                if (p.name.equals(person.name)) {
                    throw new IllegalArgumentException("Name " + person.name + " already exist in the database!");
                }
            }
            persons.add(person);
        }

    }

    @Override
    public Person getName(String name) {
        for(Person p : persons){
            if(p.name.equals(name)){
                return p;
            }
        }
        return null;
    }
}
