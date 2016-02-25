package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserService {
    private User user;
    private final Database database;
    private final AgeValidator validator;

    public UserService(User user, Database database, AgeValidator validator) {
        this.user = user;
        this.database = database;
        this.validator = validator;
    }

    public void register(User user) {
        if (validator.isAgeValid(user.age)) {
            database.save(user);
        }
    }

    public boolean isAdult(String name) {
        if (database.isUserDB(name) && validator.isAgeAdult(user.age)) {
            return true;
        }
        return false;
    }
}