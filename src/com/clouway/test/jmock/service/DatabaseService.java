package com.clouway.test.jmock.service;


/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class DatabaseService {

    private Service service;
    private Validator validator;

    /**
     * @param service   is service which regestered users.
     * @param validator is validator which validate user before registration.
     */

    public DatabaseService(Validator validator,Service service) {
        this.service = service;
        this.validator = validator;
    }

    /**
     * @param user is user which will be register in System.
     */

    public void registerUser(User user) {
        if (validator.isValid(user.age)) {
            service.registerUser(user);
        }
    }
}
