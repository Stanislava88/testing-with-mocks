package com.clouway.service;

/**
 * This interface represent DB with users
 * @author Stanislava Kaukova(sisiivanovva@gmail.com)
 */
public interface Database {
    /**
     * Save users in DB
     * @param user  {@link com.clouway.service.User} to be save
     */
    void save(User user);

    boolean isUserDB(String name);
}
