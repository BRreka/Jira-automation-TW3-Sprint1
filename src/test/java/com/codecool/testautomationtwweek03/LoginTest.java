package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.Base;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Condition.attribute;

public class LoginTest {

    WebDriver driver;
    Properties properties;
    String path;

    LoginPage loginPage;
    Base base;

    @BeforeEach
    public void setUp() {
        base = new Base();
        properties = base.initProperties();
        path = properties.getProperty("driverPath");
        System.setProperty("webdriver.chrome.driver",path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    @Test
    public void login() {loginPage = new LoginPage(driver);
       loginPage.loginToJira(properties.getProperty("username"),properties.getProperty("password") );
       loginPage.clickLogin();
       loginPage.clickProfileMenu();
       assertTrue(loginPage.findLogout());
    }


}
