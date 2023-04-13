package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.Base;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import com.codecool.testautomationtwweek03.pages.browsepages.ViewAllPage;
import com.codecool.testautomationtwweek03.pages.browsepages.coala.BrowseCoalaPage;
import com.codecool.testautomationtwweek03.pages.browsepages.coala.CoalaPage;
import com.codecool.testautomationtwweek03.pages.browsepages.jeti.BrowseJetiPage;
import com.codecool.testautomationtwweek03.pages.browsepages.jeti.JetiPage;
import com.codecool.testautomationtwweek03.pages.browsepages.mtp.BrowseMTPMainPage;
import com.codecool.testautomationtwweek03.pages.browsepages.mtp.MTPpage;
import com.codecool.testautomationtwweek03.pages.browsepages.toucan.BrowseToucanPage;
import com.codecool.testautomationtwweek03.pages.browsepages.toucan.ToucanPage;
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
    ViewAllPage viewAllPage;
    BrowseMTPMainPage browseMTPMainPage;
    MTPpage mtPpage;
    BrowseCoalaPage browseCoalaPage;
    CoalaPage coalaPage;
    BrowseJetiPage browseJetiPage;
    JetiPage jetiPage;
    BrowseToucanPage browseToucanPage;
    ToucanPage toucanPage;

    @BeforeEach
    public void setUp() {
        //webdriver util - ettől elkérni a wd-t
        base = new Base();
        properties = base.initProperties();
        driver = base.initDriver();
        path = properties.getProperty("driverPath");

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
    @Test
    public void viewAllProjects() {
        viewAllPage = new ViewAllPage(driver);
        driver.navigate().to("https://jira-auto.codecool.metastage.net/secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all");

    }

    @Test
    public void browseToucan() {

    }

    @Test
    public void browseJeti() {

    }

    @Test
    public void browseCoala() {

    }


     */
    @AfterEach
    public void teardown() {
        driver.quit();
    }

}
