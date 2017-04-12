package com.design.business.control;

/**
 * Exception related to user's password input, according to the business rules.
 */
public class PasswordException extends Exception {

    public PasswordException(String message) {
        super(message);
    }

}
