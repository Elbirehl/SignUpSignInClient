/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier.controllers;

import application.ClientApplication;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 *
 * @author 2dam
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);
    }

    public SignInControllerTest() {
    }

    //@Test
    public void test_OkResponse() {
        clickOn("#emailText");
        write("irati@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#mainWindow", isVisible());
    }

    //@Test
    public void test_UserNotRegistered() {
        clickOn("#emailText");
        write("yena@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content", hasText("User can't be found"));
    }

    //@Test
    public void test_SignInErrorEmptyFields() {
        clickOn("#btnAccept");
        verifyThat("#lblError", isVisible());
        verifyThat("#lblError", hasText("The fields cannot be empty."));
    }

    //@Test
    public void test_SignInErrorInvalidEmailFormat() {
        clickOn("#emailText");
        write("irati.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#lblError", isVisible());
        verifyThat("#lblError", hasText("The email must have a valid format"));
    }

    //@Test
    public void test_SignInUserNotActive() {
        clickOn("#emailText");
        write("olaia@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content", hasText("User is not active"));
    }

    //@Test
    public void test_TogglePasswordVisibility() { //no funciona nose que acontece
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#tgbtnEyeIcon");
        verifyThat("#tfPasswrd", isVisible());
        verifyThat("#tfPasswrd", hasText("abcd*1234"));
        clickOn("#tgbtnEyeIcon");
        verifyThat("#pfPasswrd", isVisible());
    }

    //@Test
    public void test_NavigateToSignUp() {
        clickOn("#hypSignUp");
        verifyThat("#signUpView", isVisible());
    }

    //@Test
    public void test_MaxThreadsError() { //no funciona
        //Hilo dormido
        clickOn("#emailText");
        write("irati@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content-text", hasText("Your request can't be attended. Please try later."));
    }

    //@Test
    public void test_ServerError() {  //no funciona
        //Servidor apagado
        //Base de datos apagada
        clickOn("#emailText");
        write("irati@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content-text", hasText("At this moment server is not available. Please try later."));
    }
}
