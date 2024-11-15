package uiExceptions;

/**
 * Custom exception for invalid email patterns.
 * @author  Elbire, Meylin 
 */
public class PatternEmailIncorrectException extends Exception {

    // Constructor without error message
    public PatternEmailIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternEmailIncorrectException(String msg) {
        super(msg);
    }
}
