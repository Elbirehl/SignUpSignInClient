package uiExceptions;

/**
 * Custom exception for exceeding maximum city name length.
 *
 * @author Elbire, Meylin
 */
public class MaxCityCharacterException extends Exception {

    // Constructor without error message
    public MaxCityCharacterException() {
    }

    // Constructor with a specific error message
    public MaxCityCharacterException(String msg) {
        super(msg);
    }
}
