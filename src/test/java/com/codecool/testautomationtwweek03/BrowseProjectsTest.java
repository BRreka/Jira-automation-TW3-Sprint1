package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.*;
import com.codecool.testautomationtwweek03.pages.*;
import com.codecool.testautomationtwweek03.pages.projectpages.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BrowseProjectsTest {
    static Properties properties;
    LoginPage loginPage;
    ViewAllPage viewAllPage;
    BrowseProjectMainPage browseMainPage;
    ProjectPage projectPage;
    static String baseUrl;
    @BeforeAll
    public static void setUpAll() {
        properties = PropertiesUtil.getInstance();
        baseUrl = properties.getProperty("baseUrl");
    }



    @BeforeEach
    public void setUpEach() {
        //precondition: login
        loginPage = new LoginPage();
        browseMainPage = new BrowseProjectMainPage();
        projectPage = new ProjectPage();
        viewAllPage = new ViewAllPage();
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test
    public void browseProjectInMTP() {
        NavigateUtil.navigateToPage(baseUrl + "projects/MTP/issues/");
        assertTrue(browseMainPage.getProjectTitle("Main Testing Project").isDisplayed());
        NavigateUtil.navigateToPage(baseUrl + "projects/MTP/summary");
        assertTrue(projectPage.getProjectKey("MTP").isDisplayed());
    }


    @Test
    public void viewAllProjects() {
        NavigateUtil.navigateToPage(baseUrl + "secure/BrowseProjects.jspa?selectedCategory=all&selectedProjectType=all");
        assertTrue(viewAllPage.findProjectText("COALA").isDisplayed());
        assertTrue(viewAllPage.findProjectText("JETI").isDisplayed());
        assertTrue(viewAllPage.findProjectText("TOUCAN").isDisplayed());
    }

    @Test
    public void browseToucan() {
        NavigateUtil.navigateToPage(baseUrl + "projects/TOUCAN/issues/");
        assertTrue(browseMainPage.getProjectTitle("TOUCAN project").isDisplayed());
        NavigateUtil.navigateToPage(baseUrl + "projects/TOUCAN/summary");
        assertTrue(projectPage.getProjectKey("TOUCAN").isDisplayed());
    }

    @Test
    public void browseJeti() {
        NavigateUtil.navigateToPage(baseUrl + "projects/JETI/issues/");
        assertTrue(browseMainPage.getProjectTitle("JETI project").isDisplayed());
        NavigateUtil.navigateToPage(baseUrl + "projects/JETI/summary");
        assertTrue(projectPage.getProjectKey("JETI").isDisplayed());
    }

    @Test
    public void browseCoala() {
        NavigateUtil.navigateToPage(baseUrl + "projects/COALA/issues/");
        assertTrue(browseMainPage.getProjectTitle("COALA project").isDisplayed());
        NavigateUtil.navigateToPage(baseUrl + "projects/COALA/summary");
        assertTrue(projectPage.getProjectKey("COALA").isDisplayed());
    }


    @AfterAll
    public static void teardown() {
        WebdriverUtil.quit();
    }

}
