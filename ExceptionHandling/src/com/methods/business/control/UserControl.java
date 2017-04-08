package com.methods.business.control;

import com.methods.business.model.User;
import com.methods.infra.InfraException;
import com.methods.infra.UserDAO;

import java.util.HashMap;

/**
 * Implements the business rules and communicates to the infrastructure.
 */
public class UserControl {

    private static final int LOGIN_MIN_CHAR = 1;
    private static final int LOGIN_MAX_CHAR = 20;
    private static final int PASS_MIN_CHAR = 8;
    private static final int PASS_MAX_CHAR = 12;

    // HashMap has no order and keeps unique keys (login).
    // <login, user>
    private HashMap<String, User> users;

    /**
     * Constructor loads collection of users at start.
     *
     * @throws InfraException when internal errors happen.
     */
    public UserControl() throws InfraException {
        this.users = UserDAO.load();
    }

    /**
     * Tries to add an user to the system.
     *
     * @param args are the necessary data to create an user.
     *             args[0]: login
     *             args[1]: password
     * @return an feedback message.
     * @throws InfraException for file handling.
     */
    public String add(String[] args) throws InfraException {
        String feedbackMessage = "User successfully saved.";

        try {
            validateLogin(args[0]);

            // checks if user already exists
            if (users.containsKey(args[0])) {
                return "User already exists";
            }

            validatePassword(args[1]);
            users.put(args[0], new User(args[0], args[1]));
            UserDAO.save(users);

        } catch (LoginException | PasswordException e) {
            feedbackMessage = e.getMessage();
        }

        return feedbackMessage;
    }

    /**
     * Checks if the login is valid according to business rules.
     *
     * @param login of the user.
     * @throws LoginException avoids not desired inputs.
     */
    private void validateLogin(String login) throws LoginException {
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
     * @throws PasswordException avoids not desired inputs.
     */
    private void validatePassword(String password) throws PasswordException {
        // checks password length
        if (password == null || password.length() < PASS_MIN_CHAR || password.length() > PASS_MAX_CHAR) {
            throw new PasswordException("Password must have " + PASS_MIN_CHAR + " to " + PASS_MAX_CHAR + " characters.");
        }
        // must have at least 1 letter and at least 2 numbers
        else if (!password.matches(".*[a-zA-Z].*") || !password.matches(".*\\d+.*\\d+.*")) {
            throw new PasswordException("Password must have letters and at least two numbers.");
        }
    }

    /**
     * Removes user if it exists.
     *
     * @param login of the user.
     * @return true if removed, false otherwise.
     */
    public String remove(String login) throws InfraException {
        if(users.containsKey(login)) {
            users.remove(login);
            UserDAO.save(users);
            return "User " + login + " removed.";
        }
        return "User " + login + " not found.";
    }

    public User get(String login) {
        return users.get(login);
    }

    /**
     * Lists all stored users.
     *
     * @return Iterable of User type.
     */
    public Iterable<User> listAll() {
        return users.values();
    }

}
