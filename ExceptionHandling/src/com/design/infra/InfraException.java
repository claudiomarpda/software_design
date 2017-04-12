package com.design.infra;

/**
 * Exception for infrastructure problems like DAO operations and file handling.
 */
public class InfraException extends Exception {

    private static final String FEEDBACK = "There is a infrastructure problem. Try again later.";

    public InfraException(Throwable cause) {
        super(FEEDBACK, cause);
    }

}
