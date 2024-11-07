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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignInControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);
    }

    public SignInControllerTest() {
    }

    @Test
    public void test_OkResponse() {
        clickOn("#emailText");
        write("admin@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#mainWindow", isVisible());
    }

    @Test
    public void test_UserNotRegistered() {
        clickOn("#emailText");
        write("prueba@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content", hasText("User can't be found"));
    }

    @Test
    public void test_SignInUserNotActive() {
        clickOn("#emailText");
        write("prueba23@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat(".alert", isVisible());
        verifyThat(".alert .content", hasText("User is not active"));
    }

    @Test
    public void test_MaxThreadsError() {
        clickOn("#emailText");
        write("admin@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat("Your request can't be attended. Please try later.", isVisible());
    }

    @Test
    public void test_ServerError() {
        clickOn("#emailText");
        write("admin@gmail.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat("At this moment server is not available. Please try later.", isVisible());
    }

    @Test
    public void test_SignInErrorEmptyFields() {
        clickOn("#btnAccept");
        verifyThat("#lblError", isVisible());
        verifyThat("#lblError", hasText("The fields cannot be empty."));
    }

    @Test
    public void test_NavigateToSignUp() {
        clickOn("#hypSignUp");
        verifyThat("#signUpView", isVisible());
    }

    @Test
    public void test_SignInErrorInvalidEmailFormat() {
        clickOn("#emailText");
        write("admin.com");
        clickOn("#pfPasswrd");
        write("Abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#lblError", isVisible());
        verifyThat("#lblError", hasText("The email must have a valid format"));
    }
}
