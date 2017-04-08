package com.methods.infra;

import com.methods.business.model.User;

import java.io.*;
import java.util.HashMap;

/**
 * Provides loading and saving users data to a binary file.
 */
public class UserDAO {

    private static final String FILE_NAME = "users.ser";
    private static ObjectOutputStream output; // data writing
    private static ObjectInputStream input; // data reading

    public static void save(HashMap<String, User> users) throws InfraException {
        try {
            openOutputFile();
            output.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace(); // replace with Log
            // TODO: Log it
            throw new InfraException(e);
        } finally {
            // always closes file, independently of exceptions
            closeOutputFile();
        }
    }

    @SuppressWarnings("unchecked")
    /**
     * Loads the collection of users.
     *
     * @return the previously saved users or a new instance in case there is no user saved.
     * @throws InfraException for unexpected internal errors.
     */
    public static HashMap<String, User> load() throws InfraException {
        HashMap<String, User> users = null;

        try {
            openInputFile();
            users = (HashMap<String, User>) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            // Implementation error: the reading got different type from the writing (HashMap<String, User>)
            throw new InfraException(e);
        } catch(EOFException e) {
            // Empty file: no user was previously saved.
            return new HashMap<>();
        }
        catch (IOException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            throw new InfraException(e);
        } finally {
            // always closes file, independently of exceptions
            closeInputFile();
        }

        return users;
    }

    public static void openInputFile() throws InfraException {
        try {
            input = new ObjectInputStream(new FileInputStream(FILE_NAME));
        } catch (SecurityException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            throw new InfraException(e);
        } catch (FileNotFoundException e) {
            // Creates file for the first time.
            openOutputFile();
            closeOutputFile();
            openInputFile();
            // TODO: Log it
            // [Warn level]
            //e.printStackTrace(); // replace it with Log
        } catch (IOException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            throw new InfraException(e);
        }
    }

    private static void openOutputFile() throws InfraException {
        try {
            output = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        } catch (SecurityException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            throw new InfraException(e);
        } catch (IOException e) {
            e.printStackTrace(); // replace it with Log
            // TODO: Log it
            // [Error level]
            throw new InfraException(e);
        }
    }

    /**
     * Closes the input file and handles the exception right here.
     */
    private static void closeInputFile() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace(); // replace it with Log
                // no reason to send feedback to the user
                // about the impossibility of closing the file
                // TODO: Log it
                // [Error level]
                // "Error when closing input file."
            }
        }
    }

    /**
     * Closes the output file and handles possible exception right here.
     */
    private static void closeOutputFile() {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace(); // replace it with Log
                // no reason to send feedback to the user
                // about the impossibility of closing the file
                // TODO: Log it
                // [Error level]
                // "Error when closing output file."
            }
        }
    }
}
