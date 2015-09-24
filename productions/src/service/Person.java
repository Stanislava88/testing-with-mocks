package service;

/**
 * Created by clouway on 15-8-25.
 */
public class Person {
    private String age;
    private String name;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}