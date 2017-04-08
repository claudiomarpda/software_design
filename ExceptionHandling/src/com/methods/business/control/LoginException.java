package com.methods.business.control;

/**
 * Exception related to user's login input, according to the business rules.
 */
public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }
}
