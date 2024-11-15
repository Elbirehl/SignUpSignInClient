package uiExceptions;


/**
 * Custom exception for invalid full name patterns.
 * @author Elbire y Meylin
 */

public class PatternFullNameIncorrectException extends Exception {

    // Constructor without error message
    public PatternFullNameIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternFullNameIncorrectException(String msg) {
        super(msg);
    }
}
