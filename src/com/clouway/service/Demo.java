package com.clouway.service;

/**
 * Created by clouway on 15-10-12.
 */
public class Demo {
    public static void main(String[] args) {
        BoundaryAgeValidator boundaryAgeValidator = new BoundaryAgeValidator(20,80);
        InMemoryPersonDatabase personDatabase = new InMemoryPersonDatabase();
        PersonRegistry personRegistry = new PersonRegistry(boundaryAgeValidator,personDatabase);
        try {
            personRegistry.register(new Person("John", "22"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        };

        try {
            personRegistry.register(new Person("Michael", "32"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        };

        try {
            personRegistry.register(new Person("Stephan", "76"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        };

        try {
            personRegistry.register(new Person("Stephan", "40"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        };


        try {
            personRegistry.register(new Person("George", "33"));
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        };

        Person John =  personDatabase.getName("John");
        Person Stephan = personDatabase.getName("Stephan");
        Person George = personDatabase.getName("George");
        Person Michael=personDatabase.getName("Michael");
        System.out.println(Michael.name);
        System.out.println(John.name);
        System.out.println(Stephan.name);
        System.out.println(George.name);
    }
}
