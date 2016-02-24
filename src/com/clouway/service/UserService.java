package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserService {
    private final Database database;
    private final Validator validator;

    public UserService(Database database, Validator validator) {
        this.database = database;
        this.validator = validator;
    }

    public void register(User user) {
        if (validator.isValid(user.age)) {
            database.save(user);
        }
        return;
    }
}
