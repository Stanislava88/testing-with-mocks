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

    public boolean isAdult(String name, String adultAge) {
        User user = database.findUser(name);
        if (user != null && Integer.parseInt(user.age) > Integer.parseInt(adultAge)) {
            return true;
        }
        return false;
    }
}