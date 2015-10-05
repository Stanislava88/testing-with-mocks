package com.clouway.test.jmock.service;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com)
 */
public class AgeValidator implements Validator {

    private User user;

    /**
     * @param age is User age which validator validate before user registration.
     * @return true if conditions for registration is satisfied or false if conditions is not satisfied.
     */
    @Override
    public boolean isValid(String age) {

        if (Integer.parseInt(user.age) < 18 || Integer.parseInt(user.age) > 100) {
            return false;
        }
        if (user.name == null) {
            throw new NullPointerException("Null user try to register,cannot register null user.");
        }
        if (user.name.equals("") || user.age == "") {
            throw new EmptyUserException("Empty user try to register,cannot register empty user.");
        }
        return true;
    }
}
