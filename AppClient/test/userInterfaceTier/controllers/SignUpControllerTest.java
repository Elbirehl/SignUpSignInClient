/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier.controllers;

import application.ClientApplication;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 * Testing class for SignUp view and controller Tests signUp view behavior using
 * TestFX framework
 *
 * @author Elbire and Meylin
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);
    }

    public SignUpControllerTest() {
    }

    //@Test
    public void testOKResponse() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP@example.com");
        clickOn("#pfHiddenPassword");
        write("abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("5551234567");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");

        verifyThat("#AnchorPane", isVisible());

    }

    /**
     *
     */
    @Test
    public void testServerErrorException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP@example.com");
        clickOn("#pfHiddenPassword");
        write("abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("5551234567");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");

        verifyThat("At this moment server is not available. Please try later.", isVisible());

    }

    //@Test
    public void testUserExistException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP@example.com");
        clickOn("#pfHiddenPassword");
        write("abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("5551234567");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");

        verifyThat("The email entered is already in use.", isVisible());

    }

    //@Test
    public void testMaxThreadsErrorException() {
        clickOn("#hypSignUp");
        clickOn("#tfFullName");
        write("Pedro Pascal");
        clickOn("#tfEmail");
        write("pedroP@example.com");
        clickOn("#pfHiddenPassword");
        write("abcd*1234");
        clickOn("#tgbEyePasswd");
        clickOn("#pfHiddenConfirmPassword");
        write("abcd*1234");
        clickOn("#tgbEyeConfirmPasswd");
        clickOn("#tfStreet");
        write("123 Main St");
        clickOn("#tfZip");
        write("12345");
        clickOn("#tfCity");
        write("New York");
        clickOn("#tfMobile");
        write("5551234567");
        clickOn("#cbxStatus");
        clickOn("#btnSignUp");

        verifyThat("The email entered is already in use.", isVisible());

    }

}


