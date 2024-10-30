package uiExceptions;

import javafx.scene.control.TextField;

/**
 * Custom exception to validate the format of a password. Ensures that the
 * password meets specific format requirements: - Minimum 8 characters - At
 * least one uppercase letter - At least one lowercase letter - At least one
 * digit - At least one special character (e.g., !@#$%^&*(),.?":{}|)
 *
 * This exception is thrown if any of these conditions are not met.
 *
 * @author Meylin
 */
public class PatternPasswordIncorrectException extends Exception {

    /**
     * Default constructor for PatternPasswordIncorrectException without an
     * error message.
     */
    public PatternPasswordIncorrectException() {
    }

    /**
     * Constructs a PatternPasswordIncorrectException with the specified error
     * message.
     *
     * @param msg the detail message
     */
    public PatternPasswordIncorrectException(String msg) {
        super(msg);
    }

    /**
     * Validates the format of the password entered in the provided text field.
     *
     * @param tfPassword the TextField containing the password to validate
     * @throws PatternPasswordIncorrectException if the password does not meet
     * the format requirements
     */
    public static void validatePasswordFormat(TextField tfPassword) throws PatternPasswordIncorrectException {
        String password = tfPassword.getText();
        System.out.println("Ha entrado a validar");
        
        // Check if password has at least 8 characters
        if (password.length() < 8) {
            throw new PatternPasswordIncorrectException("Password must be at least 8 characters long");
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            throw new PatternPasswordIncorrectException("Password must contain at least one uppercase letter");
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            throw new PatternPasswordIncorrectException("Password must contain at least one lowercase letter");
        }

        // Check if password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            throw new PatternPasswordIncorrectException("Password must contain at least one digit");
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new PatternPasswordIncorrectException("Password must contain at least one special character");
        }
    }
}
