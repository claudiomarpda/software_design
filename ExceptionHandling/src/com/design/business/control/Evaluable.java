package com.design.business.control;

/**
 * Allows communication to the class that implements it, giving independence for the class clients.
 */
public interface Evaluable {

    void validateLogin(String login) throws LoginException;
    void validatePassword(String password) throws PasswordException;
}
