package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.PropertiesUtil;
import com.codecool.testautomationtwweek03.util.WebdriverUtil;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import org.junit.jupiter.api.*;

import java.util.Properties;

public class LogoutTest {

    static Properties properties;

    LoginPage loginPage;

    @BeforeAll
    public static void setUpAll() {
        properties = PropertiesUtil.getInstance();
    }

    @BeforeEach
    public void setUp() {
        loginPage = new LoginPage();
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test
    public void logout(){
        loginPage.clickProfileMenu();
        loginPage.clickLogout();
    }
    @AfterEach
    public void teardown() {
        WebdriverUtil.quit();
    }
}
