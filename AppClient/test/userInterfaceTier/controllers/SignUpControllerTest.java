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
import org.testfx.api.FxAssert;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxRobot;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 * Testing class for SignUp view and controller
 * Tests signUp view behavior using TestFX framework
 * @author Elbire and Meylin
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpControllerTest extends ApplicationTest{
    
    @Override 
    public void start(Stage stage) throws Exception{
        new ClientApplication().start(stage);
    }
    
    public SignUpControllerTest() {
    }
    
    @Test
    public void testSignInOK() {
        clickOn("#emailText");
        write("elbire@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat("#AnchorPane",isVisible());
    }

    //@Test
    public void testSignInErrorEmail() {
        clickOn("#emailText");
        write("elbir@gmail.com");
        clickOn("#pfPasswrd");
        write("abcd*1234");
        clickOn("#btnAccept");
        verifyThat("User can't be found",isVisible());
    }
    
}
