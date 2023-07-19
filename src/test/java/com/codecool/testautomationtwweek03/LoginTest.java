package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.*;
import com.codecool.testautomationtwweek03.pages.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    String errorMessage = "Sorry, your username and password are incorrect - please try again.";
    static Properties properties;
    ProfilePage profPage;
    LoginPage loginPage;

    @BeforeAll
    public static void setUpAll() {
        properties = PropertiesUtil.getInstance();
    }

    @BeforeEach
    public void setUpEach() {
        loginPage = new LoginPage();
        profPage = new ProfilePage();
    }


    @Test
    public void login() {
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
        loginPage.clickProfileMenu();
        //loginPage.findLogout();
        profPage.manageDriver();
        assertEquals(properties.getProperty("username"), profPage.getUsernameFromProfile());
    }

    @Test
    public void loginNoCredentials() {
        loginPage.loginToJira("", "");
        assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @Test
    public void loginBadPassword() {
        loginPage.loginToJira(properties.getProperty("username"), "greenEarMonkeys");
        assertEquals(errorMessage, loginPage.getErrorMessage());
    }
    @Test
    public void loginNoPassword() {
        loginPage.loginToJira(properties.getProperty("username"), "");
        assertEquals(errorMessage, loginPage.getErrorMessage());
    }

    @AfterEach
    public void teardown() {
        WebdriverUtil.quit();
    }
}
