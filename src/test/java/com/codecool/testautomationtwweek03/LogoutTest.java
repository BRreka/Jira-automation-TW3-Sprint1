package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.WebdriverUtil;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {

    WebDriver driver;
    Properties properties;
    String path;

    LoginPage loginPage;
    WebdriverUtil base;

    @BeforeEach
    public void setUp() {
        base = new WebdriverUtil();
        properties = base.initProperties();
        driver = base.initDriver();
        path = properties.getProperty("driverPath");

        loginPage = new LoginPage(driver);
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password") );
    }

    @Test
    public void logout(){
        loginPage.clickProfileMenu();
        loginPage.clickLogout();
    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
