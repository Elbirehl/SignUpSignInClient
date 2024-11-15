package uiExceptions;

import javafx.scene.control.TextField;

/**
 * Custom exception for incorrect mobile number format.
 *
 * @author Elbire, Meylin
 */
public class PatternMobileIncorrectException extends Exception {

    public static void validateMobileFormat(TextField tfMobile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public PatternMobileIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternMobileIncorrectException(String msg) {
        super(msg);
    }

  
}
