package com.design.business.control;

/**
 * Validator manages the business rules. It implements the Evaluable interface
 * so its client can access it without really knowing it, this is,
 * through the interface.
 */
public class Validator implements Evaluable {

    private static final int LOGIN_MIN_CHAR = 1;
    private static final int LOGIN_MAX_CHAR = 20;
    private static final int PASS_MIN_CHAR = 8;
    private static final int PASS_MAX_CHAR = 12;

    /**
     * Checks if the login is valid according to business rules.
     *
     * @param login of the user.
     * @throws LoginException if some not desired inputs is given.
     */
    @Override
    public void validateLogin(String login) throws LoginException {
        // checks login length
        if (login == null || login.length() < LOGIN_MIN_CHAR || login.length() > LOGIN_MAX_CHAR) {
            throw new LoginException("Login must have " + LOGIN_MIN_CHAR + " to " + LOGIN_MAX_CHAR + " characters.");
        }
        // must not have numbers
        else if (login.matches(".*\\d.*")) {
            throw new LoginException("Login has number characters.");
        }
    }

    /**
     * Checks if the password is valid according to business rules.
     *
     * @param password of the user
     * @throws PasswordException if some not desired inputs is given.
     */
    @Override
    public void validatePassword(String password) throws PasswordException {
        // checks password length
        if (password == null || password.length() < PASS_MIN_CHAR || password.length() > PASS_MAX_CHAR) {
            throw new PasswordException("Password must have " + PASS_MIN_CHAR + " to " + PASS_MAX_CHAR + " characters.");
        }
        // must have at least 1 letter and at least 2 numbers
        else if (!password.matches(".*[a-zA-Z].*") || !password.matches(".*\\d+.*\\d+.*")) {
            throw new PasswordException("Password must have letters and at least two numbers.");
        }
    }
}
