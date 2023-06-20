package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.init.WebdriverUtil;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import com.codecool.testautomationtwweek03.pages.browsepages.ViewAllPage;
import com.codecool.testautomationtwweek03.pages.browsepages.BrowseProjectMainPage;
import com.codecool.testautomationtwweek03.pages.browsepages.ProjectPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseProjectsTest {
    WebDriver driver;
    Properties properties;
    String path;
    WebdriverUtil base;
    LoginPage loginPage;
    ViewAllPage viewAllPage;
    BrowseProjectMainPage browseMTPMainPage;
    ProjectPage mtPpage;

    @BeforeEach
    public void setUp() {
        //webdriver util - ettől elkérni a wd-t
        base = new WebdriverUtil();
        properties = base.initProperties();
        driver = base.initDriver();
        path = properties.getProperty("driverPath");

        //precondition: login
        loginPage = new LoginPage(driver);
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test
    public void browseProjectInMTP() {
        browseMTPMainPage = new BrowseProjectMainPage(driver);
        mtPpage = new ProjectPage(driver);
        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/MTP/issues/");
        assertTrue(browseMTPMainPage.isMainTestingProjectTitleDisplayed());
        //browseMTPMainPage.clickTitle();
        driver.navigate().to("https://jira-auto.codecool.metastage.net/projects/MTP/summary");
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
