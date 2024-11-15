package uiExceptions;

/**
 * Custom exception for mismatched passwords.
 *
 * @author Elbire, Meylin
 */
public class PasswdsDontMatchException extends Exception {

    // Constructor without error message
    public PasswdsDontMatchException() {
    }

    // Constructor with a specific error message
    public PasswdsDontMatchException(String msg) {
        super(msg);
    }
}
