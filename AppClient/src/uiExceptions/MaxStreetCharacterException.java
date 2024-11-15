package uiExceptions;

import javafx.scene.control.TextField;

/**
 * Custom exception for exceeding maximum street length.
 *
 * @author Elbire,Meylin
 */
public class MaxStreetCharacterException extends Exception {

    public static void validateStreetLength(TextField tfStreet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public MaxStreetCharacterException() {
    }

    // Constructor with a specific error message
    public MaxStreetCharacterException(String msg) {
        super(msg);
    }

}
