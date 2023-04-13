package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.Base;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import com.codecool.testautomationtwweek03.pages.ProfilePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    WebDriver driver;
    Properties properties;
    String path;
    ProfilePage profPage;
    LoginPage loginPage;
    Base base;

    @BeforeEach
    public void setUp() {
        base = new Base();
        properties = base.initProperties();
        path = properties.getProperty("driverPath");
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    @Test
    public void login() {
        loginPage = new LoginPage(driver);
        profPage = new ProfilePage(driver);
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
        //loginPage.clickLogin();
        loginPage.clickProfileMenu();
        assertTrue(loginPage.findLogout());
        driver.navigate().to("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");
        assertEquals(properties.getProperty("username"), profPage.getUsernameFromProfile());
    }

    @Test
    public void loginNoCredentials() {
        loginPage = new LoginPage(driver);
        profPage = new ProfilePage(driver);
        loginPage.loginToJira("", "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }

    @Test
    public void loginBadPassword() {
        loginPage = new LoginPage(driver);
        profPage = new ProfilePage(driver);
        loginPage.loginToJira(properties.getProperty("username"), "greenEarMonkeys");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }
    @Test
    public void loginNoPassword() {
        loginPage = new LoginPage(driver);
        profPage = new ProfilePage(driver);
        loginPage.loginToJira(properties.getProperty("username"), "");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Sorry, your username and password are incorrect - please try again.", loginPage.getErrorMessage());
    }


    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
