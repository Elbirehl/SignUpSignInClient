package uiExceptions;

/**
 * Custom exception for incorrect mobile number format.
 *
 * @author Elbire, Meylin
 */
public class PatternMobileIncorrectException extends Exception {

    // Constructor without error message
    public PatternMobileIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternMobileIncorrectException(String msg) {
        super(msg);
    }
}
