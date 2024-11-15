package uiExceptions;

import javafx.scene.control.TextField;

/**
 * Custom exception for exceeding maximum city name length.
 *
 * @author Elbire, Meylin
 */
public class MaxCityCharacterException extends Exception {

    public static void validateCityLength(TextField tfCity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public MaxCityCharacterException() {
    }

    // Constructor with a specific error message
    public MaxCityCharacterException(String msg) {
        super(msg);
    }

}
