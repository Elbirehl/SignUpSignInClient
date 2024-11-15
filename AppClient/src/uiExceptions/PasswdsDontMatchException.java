package uiExceptions;

import javafx.scene.control.PasswordField;


/**
 * Custom exception for mismatched passwords.
 * @author Elbire, Meylin
 */
public class PasswdsDontMatchException extends Exception {

    public static void validatePasswords(PasswordField pfHiddenPassword, PasswordField pfHiddenConfirmPassword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Constructor without error message
    public PasswdsDontMatchException() {
    }

    // Constructor with a specific error message
    public PasswdsDontMatchException(String msg) {
        super(msg);
    }

   
}
