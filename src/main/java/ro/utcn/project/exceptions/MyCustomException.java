package ro.utcn.project.exceptions;

/**
 * If you prefer to use exceptions instead of messages.
 * Create custom exceptions each time you need one.
 */

public class MyCustomException extends Exception {

    public MyCustomException(String error) {
        super(error);
    }
}
