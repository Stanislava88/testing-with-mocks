package com.clouway.service;

/**
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public class UserService {
    private final UserRepository database;
    private final AgeValidator validator;

    public UserService(UserRepository database, AgeValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public void register(User user) {
        if (validator.isValid(user.age)) {
            database.save(user);
        }
    }

    public boolean isAdult(String name, int adultAge) {
        User user = database.findByName(name);

        if (user == null) {
            return false;
        }

        return Integer.parseInt(user.age) > adultAge;
    }
}