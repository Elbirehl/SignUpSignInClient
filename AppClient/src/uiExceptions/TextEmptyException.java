package uiExceptions;


/**
 * Custom exception class for handling empty text fields.
 * This exception is thrown when validation checks reveal that required text fields 
 * are empty, ensuring that all necessary user input is provided.
 * 
 * The class provides static methods for validating multiple text fields as well as individual fields.
 * It allows the application to enforce rules regarding user input during sign-up or similar processes.
 * 
 * @author Irati
 */
public class TextEmptyException extends Exception {

    // Constructor without error message
    public TextEmptyException() {
    }

    // Constructor with a specific error message
    public TextEmptyException(String msg) {
        super(msg);
    }   
}
