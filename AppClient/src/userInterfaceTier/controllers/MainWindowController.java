/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier.controllers;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logicalModel.interfaces.Signable;
import logicalModel.model.User;

/**
 * Controller for the main application window.
 * Manages user interaction with the UI and handles the logic for logging out 
 * and exiting the application.
 * 
 * @author olaia
 */
public class MainWindowController {

    @FXML
    private AnchorPane signUpView;

    @FXML
    private TitledPane tpMenu;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnExit;

    @FXML
    private TextField tfFullName;

    @FXML
    private Label lblFullName;

    @FXML
    private TextField tfEmail;

    @FXML
    private Label lblEmail;

    @FXML
    private TextField tfMobile;

    @FXML
    private Label lblMobile;

    @FXML
    private TextField tfActive;

    @FXML
    private Label lblActive;

    private Stage stage;

     /**
     * Sets the main window stage.
     * 
     * @param stage the main window stage.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Stage signInStage;

   /**
     * Sets the sign-in stage.
     * 
     * @param signInStage the sign-in stage.
     */
    public void signInStage(Stage signInStage) {
        this.signInStage = stage;
    }

    private Signable signable;

   /**
     * Initializes the main window with data from the signed-in user.
     * 
     * @param root the root node of the scene.
     * @param userSignedIn the user who has signed in.
     */
    public void initStage(Parent root, User userSignedIn) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //Window title set to "MainWindow".
        stage.setTitle("MainWindow");
        //Adding a custom icon.
        Image icon = new Image(getClass().getResourceAsStream("/resources/images/catrina.png"));
        stage.getIcons().add(icon);
        stage.setResizable(false);
        tfFullName.isFocused();
        btnExit.setOnAction(this::handleExit);
        btnLogOut.setOnAction(this::handleLogOut);
        tfFullName.setText(userSignedIn.getName());
        tfEmail.setText(userSignedIn.getEmail());
        tfMobile.setText(String.valueOf(userSignedIn.getMobile()));
        tfActive.setText(userSignedIn.isActive() ? "Active" : "Inactive");
        stage.show();
    }

    //The user's data (nickname, email, mobile, and user status) are loaded and displayed in individual TextFields within the window.
    //Closes the window and exits the application.
     /**
     * Handles the action to exit the application.
     * Displays a confirmation dialog before exiting the application.
     * 
     * @param event the action event.
     */
    private void handleExit(ActionEvent event) {
        //Request user confirmation to exit.
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Exit");
        alert.setHeaderText("You are about to exit the application.");
        alert.setContentText("Are you sure you want to exit?");

        //If the user confirms, the session is closed. If not, the main window remains open.
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Closes the application
            Platform.exit();
        }
    }

    //Closes the window and starts the Sign In window.
    /**
     * Handles the log-out action.
     * Displays a confirmation dialog before logging out and loading the sign-in window.
     * 
     * @param event the action event.
     */
    private void handleLogOut(ActionEvent event) {
        //Request user confirmation to log out.
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Log Out");
        alert.setHeaderText("You are about to log out.");
        alert.setContentText("Are you sure you want to log out?");

        //If the user confirms, the session is closed. If not, the main window remains open.
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Close the current window (Main Window)
                stage.close();

                // Load the Sign In window
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterfaceTier/view/SignInView.fxml"));
                Parent root = (Parent) loader.load();

                SignInController signInController = loader.getController();

                Stage signInStage = new Stage();

                signInController.setStage(signInStage);

                signInController.initStage(root);

            } catch (IOException e) {
                Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
