/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier.controllers;

import application.ClientApplication;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 * This class contains unit tests for the main window controller in the
 * application.
 *
 * Author: olaia
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainWindowControllerTest extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);
    }

    public MainWindowControllerTest() {
    }

    //Comprobar que esten bien.
    //@Test
    public void test1_LogOutOk() {
        clickOn("#emailText");
        write("olaialor@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd");
        clickOn("#btnAccept");
        verifyThat("#mainWindow", isVisible());

        clickOn("#tpMenu");
        sleep(500);
        verifyThat("#btnLogOut", isVisible());
        clickOn("#btnLogOut");
        verifyThat("Are you sure you want to log out?", isVisible());
        clickOn("Aceptar");

        verifyThat("#pane", isVisible());
    }

    //@Test
    public void test2_LogOutCancel() {
        // Simular inicio de sesión
        clickOn("#emailText");
        write("olaialor@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd");
        clickOn("#btnAccept");
        verifyThat("#mainWindow", isVisible());

        clickOn("#tpMenu");
        sleep(500);
        verifyThat("#btnLogOut", isVisible());
        clickOn("#btnLogOut");
        verifyThat("Are you sure you want to log out?", isVisible());
        clickOn("Cancelar");

        verifyThat("#mainWindow", isVisible());
    }

    @Test
    public void testUserData() {
        clickOn("#emailText");
        write("olaialor@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd");
        clickOn("#btnAccept");
        verifyThat("#mainWindow", isVisible());

        String expectedName = "olaia";
        String expectedEmail = "olaialor@gmail.com";
        String expectedMobile = "628410255";
        String expectedStatus = "Active";

        TextField tfFullName = lookup("#tfFullName").query();
        assertEquals(expectedName, tfFullName.getText());
        assertFalse("tfFullName should be non-editable", tfFullName.isEditable());

        TextField tfEmail = lookup("#tfEmail").query();
        assertEquals(expectedEmail, tfEmail.getText());
        assertFalse("tfEmail should be non-editable", tfEmail.isEditable());

        TextField tfMobile = lookup("#tfMobile").query();
        assertEquals(expectedMobile, tfMobile.getText());
        assertFalse("tfMobile should be non-editable", tfMobile.isEditable());

        TextField tfActive = lookup("#tfActive").query();
        assertEquals(expectedStatus, tfActive.getText());
        assertFalse("tfActive should be non-editable", tfActive.isEditable());
    }
}
