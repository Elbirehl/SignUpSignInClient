package userInterfaceTier.controllers;

import application.ClientApplication;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);
    }

    public SignUpControllerTest() {
    }

    @Test
    public void test_1_OKResponse() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Admin");
        clickOn("#tfEmail");
        write("admin@gmail.com");
        clickOn("#pfHiddenPassword");
        write("Abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("Abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("Medina de Pomar");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("Burgos");
        clickOn("#tfMobile");
        write("123456789");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");
        clickOn("Aceptar");
        verifyThat("#signIn", isVisible());
    }

    @Test
    public void test_2_UserExistException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Admin");
        clickOn("#tfEmail");
        write("admin@gmail.com");
        clickOn("#pfHiddenPassword");
        write("Abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("Abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("123456789");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");
        verifyThat("The email entered is already in use.", isVisible());
        clickOn("Aceptar");
    }

    @Test
    public void test_3_ServerErrorException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP@example.com");
        clickOn("#pfHiddenPassword");
        write("AbcD*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("AbcD*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("688740055");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");
        verifyThat("At this moment server is not available. Please try later.", isVisible());
        clickOn("Aceptar");
    }

    @Test
    public void test_4_MaxThreadsErrorException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP1232345@example.com");
        clickOn("#pfHiddenPassword");
        write("AbcD*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("AbcD*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("688740055");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");
        verifyThat("Your request can't be attended. Please try later.", isVisible());
    }
}
