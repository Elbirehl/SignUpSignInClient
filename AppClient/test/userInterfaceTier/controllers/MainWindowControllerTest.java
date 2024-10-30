/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterfaceTier.controllers;

import application.ClientApplication;
//import java.awt.TextField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runners.MethodSorters;
//import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
//import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author 2dam
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainWindowControllerTest extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        new ClientApplication().start(stage);

    }

    public MainWindowControllerTest() {
    }

    @Test
    public void testLogout() {
        clickOn("#emailText");
        write("elbire@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#AnchorPane", isVisible());
        clickOn("#btnLogOut");
        verifyThat("Confirm Log Out", isVisible());
        clickOn("Ok");
        verifyThat("#AnchorPane", isVisible());

    }

    @Test
    public void testUserData() {
        clickOn("#emailText");
        write("elbire@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");

        verifyThat("#AnchorPane", isVisible());

        String expectedName = "elbire";
        String expectedEmail = "elbire@gmail.com";
        String expectedMobile = "123456789";
        String expectedStatus = "Active";

        TextField tfFullName = lookup("#tfFullName").query();
        assertEquals(expectedName, tfFullName.getText());
        assertFalse("tfFullName debe ser no editable", tfFullName.isEditable());

        TextField tfEmail = lookup("#tfEmail").query();
        assertEquals(expectedEmail, tfEmail.getText());
        assertFalse("tfEmail debe ser no editable", tfEmail.isEditable());

        TextField tfMobile = lookup("#tfMobile").query();
        assertEquals(expectedMobile, tfMobile.getText());
        assertFalse("tfMobile debe ser no editable", tfMobile.isEditable());

        TextField tfActive = lookup("#tfActive").query();
        assertEquals(expectedStatus, tfActive.getText());
        assertFalse("tfActive debe ser no editable", tfActive.isEditable());

    }

}
