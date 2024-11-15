package userInterfaceTier.controllers;

import uiExceptions.TextEmptyException;
import clientBusinessLogic.ClientFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import logicalExceptions.MaxThreadsErrorException;
import logicalExceptions.ServerErrorException;
import logicalExceptions.SignInErrorException;
import logicalExceptions.UserNotActiveException;
import logicalModel.interfaces.Signable;
import logicalModel.model.User;
import uiExceptions.MaxCityCharacterException;
import uiExceptions.PatternEmailIncorrectException;

/**
 * Controller for the Sign-In functionality. Manages user interactions and
 * validations for the Sign-In process.
 */
public class SignInController {

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField pfPasswrd;

    @FXML
    private TextField tfPasswrd;

    @FXML
    private ToggleButton tgbtnEyeIcon;

    @FXML
    private ImageView ivEyeIcon;

    @FXML
    private Label lblError;

    @FXML
    private Button btnAccept;

    @FXML
    private Hyperlink hypSignUp;

    private Logger logger = Logger.getLogger(SignInController.class.getName());

    private Stage stage;

    // Variable de instancia para almacenar el objeto Signable
    private Signable signable;

    public SignInController() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void initStage(Parent root) {
        try {
            logger.info("Initializing Sign In stage");

            // Obtén el objeto Signable una vez durante la inicialización
            this.signable = ClientFactory.getSignable();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Sign In");
            stage.setResizable(false);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/catrina.png")));
            emailText.isFocused();
            ivEyeIcon.setImage(new Image("/resources/images/ShowPasswd.png"));
            lblError.setText("");
            btnAccept.setDefaultButton(true);
            tfPasswrd.setVisible(false);

            pfPasswrd.textProperty().addListener(this::textPropertyChange);
            tfPasswrd.textProperty().addListener(this::textPropertyChange);
            tgbtnEyeIcon.setOnAction(this::handelEyeIconToggleButtonAction);
            hypSignUp.setOnAction(this::handelSignUpHyperlink);
            stage.show();
        } catch (Exception e) {
            handleUnexpectedError("Error opening window", e);
        }
    }

    public void textPropertyChange(ObservableValue observable, String oldValue, String newValue) {
        // Resetea el texto de lblError
        lblError.setText("");

        // Sincroniza los campos de texto dependiendo de cuál es visible
        if (pfPasswrd.isVisible()) {
            tfPasswrd.setText(pfPasswrd.getText());
        } else if (tfPasswrd.isVisible()) {
            pfPasswrd.setText(tfPasswrd.getText());
        }
    }

// Agrega un listener similar para emailText
    @FXML
    public void initialize() {
        emailText.textProperty().addListener((observable, oldValue, newValue) -> lblError.setText(""));
        // Si ya tienes un método initStage que agrega listeners, también lo puedes hacer allí.
    }

    @FXML
    public void handelEyeIconToggleButtonAction(ActionEvent event) {
        if (tgbtnEyeIcon.isSelected()) {
            pfPasswrd.setVisible(false);
            tfPasswrd.setVisible(true);
            ivEyeIcon.setImage(new Image("/resources/images/HidePasswd.png"));
        } else {
            tfPasswrd.setVisible(false);
            pfPasswrd.setVisible(true);
            ivEyeIcon.setImage(new Image("/resources/images/ShowPasswd.png"));
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String email = emailText.getText().trim();
        String passwrd = pfPasswrd.getText().trim();

        try {
            // Validar campos vacíos
            if (email.isEmpty() || passwrd.isEmpty()) {
                throw new TextEmptyException("Fields cannot be empty.");
            }

            // Validar el formato del correo electrónico
            if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email)) {
                throw new PatternEmailIncorrectException("Invalid email format.");
            }

            // Crear objeto usuario y llamar al método de inicio de sesión
            User user = new User(email, passwrd);
            User userSignedIn = this.signable.signIn(user);

            // Proceder a la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterfaceTier/view/MainWindowView.fxml"));
            Parent root = loader.load();
            MainWindowController controller = loader.getController();
            controller.setStage(stage);
            controller.initStage(root, userSignedIn);

        } catch (TextEmptyException | PatternEmailIncorrectException e) {
            // Mostrar el mensaje de error cuando el campo está vacío o el correo es incorrecto
            lblError.setText(e.getMessage());
            logger.warning(e.getMessage());
        } catch (SignInErrorException e) {
            showErrorAlert("Sign-In Error", "User can't be found. Please check your credentials.");
        } catch (UserNotActiveException e) {
            showErrorAlert("User Inactive", "Your account is inactive. Please contact support.");
        } catch (MaxThreadsErrorException e) {
            showErrorAlert("Server Busy", "Please try again later. Too many requests.");
        } catch (ServerErrorException e) {
            showErrorAlert("Server Unavailable", "The server is currently down. Please try again later.");
        } catch (IOException e) {
            handleUnexpectedError("Error loading the main window", e);
        }
    }

    @FXML
    private void handelSignUpHyperlink(ActionEvent event) {
        try {
            resetFields();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterfaceTier/view/SignUpView.fxml"));
            Parent root = loader.load();
            SignUpController controller = loader.getController();
            controller.initStage(root);
        } catch (IOException e) {
            handleUnexpectedError("Error opening Sign-Up window", e);
        }
    }

    private void validateInputs(String email, String passwrd) throws TextEmptyException, PatternEmailIncorrectException {
        if (email.isEmpty() || passwrd.isEmpty()) {
            throw new TextEmptyException("Fields cannot be empty.");
        }
        if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", email)) {
            throw new PatternEmailIncorrectException("Invalid email format.");
        }
    }

    private void showErrorAlert(String title, String message) {
        new Alert(Alert.AlertType.ERROR, message, ButtonType.OK).showAndWait();
        logger.warning(message);
    }

    private void handleUnexpectedError(String context, Exception e) {
        logger.log(Level.SEVERE, context, e);
        new Alert(Alert.AlertType.ERROR, "An unexpected error occurred. Please try again.", ButtonType.OK).showAndWait();
    }

    private void resetFields() {
        emailText.setText("");
        pfPasswrd.setText("");
        tfPasswrd.setText("");
        lblError.setText("");
    }
}
