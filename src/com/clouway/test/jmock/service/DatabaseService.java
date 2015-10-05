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

    public DatabaseService(Service service, Validator validator) {
        this.service = service;
        this.validator = validator;
    }

    /**
     * @param user is user which will be register in System.
     */

    public void register(User user) {
        if (validator.isValid(user.age)) {
            service.register(user);
        }
    }
}
