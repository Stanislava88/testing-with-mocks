package com.clouway.service;

/**
 * The implementation of this interface will be used to save and find user
 *
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface UserRepository {
    /**
     * Save user
     *
     * @param user {@link com.clouway.service.User} to be save
     */
    void save(User user);

    /**
     * Will return user
     *
     * @param name user name
     * @return report of searching
     */
    User findUser(String name);
}
