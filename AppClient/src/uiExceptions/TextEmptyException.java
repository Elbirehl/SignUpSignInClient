package uiExceptions;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Custom exception class for handling empty text fields. This exception is
 * thrown when validation checks reveal that required text fields are empty,
 * ensuring that all necessary user input is provided.
 *
 * The class provides static methods for validating multiple text fields as well
 * as individual fields. It allows the application to enforce rules regarding
 * user input during sign-up or similar processes.
 *
 * @author Irati
 */
public class TextEmptyException extends Exception {

    public static void checkFields(TextField tfFullName, TextField tfEmail, PasswordField pfHiddenPassword, PasswordField pfHiddenConfirmPassword, TextField tfStreet, TextField tfCity, TextField tfZip, TextField tfMobile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public TextEmptyException() {
    }

    // Constructor with a specific error message
    public TextEmptyException(String msg) {
        super(msg);
    }

}
