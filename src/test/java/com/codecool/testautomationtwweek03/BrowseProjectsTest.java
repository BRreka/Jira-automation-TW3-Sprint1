package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.Base;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import com.codecool.testautomationtwweek03.pages.browsepages.BrowseMTPMainPage;
import com.codecool.testautomationtwweek03.pages.browsepages.MTPpage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseProjectsTest {
    WebDriver driver;
    Properties properties;
    String path;
    Base base;
    LoginPage loginPage;
    BrowseMTPMainPage browseMTPMainPage;
    MTPpage mtPpage;

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

        //precondition: login
        loginPage = new LoginPage(driver);
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test
    public void browseProjectInMTP() {
        browseMTPMainPage = new BrowseMTPMainPage(driver);
        mtPpage = new MTPpage(driver);
        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/MTP/issues/");
        assertTrue(browseMTPMainPage.isMainTestingProjectTitleDisplayed());
        browseMTPMainPage.clickTitle();
        assertTrue(mtPpage.isMTPKeyPresent());
    }
/*
    @AfterEach
    public void teardown() {
        driver.close();
    }

 */

}
