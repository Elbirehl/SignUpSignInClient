package uiExceptions;

import javafx.scene.control.TextField;
import java.util.regex.Pattern;

/**
 * Custom exception for invalid email patterns.
 * @author  Elbire, Meylin 
 */
public class PatternEmailIncorrectException extends Exception {

    public static void validateEmail(TextField tfEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public PatternEmailIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternEmailIncorrectException(String msg) {
        super(msg);
    }

}
