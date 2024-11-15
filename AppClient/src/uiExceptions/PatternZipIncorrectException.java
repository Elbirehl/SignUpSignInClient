package uiExceptions;

import javafx.scene.control.TextField;

/**
 * Custom exception for incorrect ZIP code format.
 * @author Elbire, Meylin
 */
public class PatternZipIncorrectException extends Exception {

    public static void validateZipFormat(TextField tfZip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public PatternZipIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternZipIncorrectException(String msg) {
        super(msg);
    }

}
