package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserService {
    private final Database database;
    private final AgeValidator validator;

    public UserService(Database database, AgeValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public void register(User user) {
        if (validator.isAgeValid(user.age)) {
            database.save(user);
        }
    }

    public boolean isAdult(String name) {
        User user = database.findUser(name);
        if (user != null && validator.isAgeAdult(user.age)) {
            return true;
        }
        return false;
    }
}