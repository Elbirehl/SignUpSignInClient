package uiExceptions;

import javafx.scene.control.TextField;
import java.util.regex.Pattern;

/**
 * Custom exception for invalid full name patterns.
 * @author Elbire y Meylin
 */

public class PatternFullNameIncorrectException extends Exception {

    public static void validateFullName(TextField tfFullName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public PatternFullNameIncorrectException() {
    }

    // Constructor with a specific error message
    public PatternFullNameIncorrectException(String msg) {
        super(msg);
    }

  
}
