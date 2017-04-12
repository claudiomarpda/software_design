package com.design.business.control;

import com.design.business.model.User;
import com.design.infra.InfraException;
import com.design.infra.UserDAO;

import java.util.HashMap;

/**
 * Implements the business rules and communicates to the infrastructure.
 */
public class UserControl {

    // HashMap has no order and keeps unique keys (login).
    // <login, user>
    private HashMap<String, User> users;
    private Evaluable evaluable;

    /**
     * Constructor loads collection of users at start.
     *
     * @throws InfraException when internal errors happen.
     */
    public UserControl(Evaluable evaluable) throws InfraException {
        this.users = UserDAO.load();
        this.evaluable = evaluable;
    }

    /**
     * Tries to add an user to the system.
     *
     * @param args are the necessary data to create an user.
     *             args[0]: login
     *             args[1]: password
     * @return true if succeed, false otherwise.
     * @throws InfraException for internal errors.
     */
    public boolean add(String[] args) throws InfraException, LoginException, PasswordException {
        evaluable.validateLogin(args[0]);

        // checks if user already exists
        if (users.containsKey(args[0])) {
            return false;
        }

        evaluable.validatePassword(args[1]);
        users.put(args[0], new User(args[0], args[1]));
        UserDAO.save(users);

        return true;
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
