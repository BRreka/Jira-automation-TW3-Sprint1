package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.*;
import com.codecool.testautomationtwweek03.pages.*;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

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
        loginPage = new LoginPage();
        profPage = new ProfilePage();
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
        loginPage.clickProfileMenu();
        loginPage.findLogout();
        driver.navigate().to("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
        assertEquals(properties.getProperty("username"), profPage.getUsernameFromProfile());
    }

    @Test
    public void loginNoCredentials() {
        loginPage.loginToJira("", "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }

    @Test
    public void loginBadPassword() {
        loginPage.loginToJira(properties.getProperty("username"), "greenEarMonkeys");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }
    @Test
    public void loginNoPassword() {
        loginPage.loginToJira(properties.getProperty("username"), "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }


    @AfterEach
    public void teardown() {
        WebdriverUtil.quit();
    }
}
