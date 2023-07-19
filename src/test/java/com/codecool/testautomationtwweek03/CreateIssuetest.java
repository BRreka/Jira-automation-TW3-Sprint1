package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.WebdriverUtil;
import com.codecool.testautomationtwweek03.pages.CreatIssue;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CreateIssuetest {
    WebDriver driver;
    Properties properties;
    String path;
   CreatIssue issue;
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


        issue = new CreatIssue(driver);
    }
    @Test
    public void createIssueTest(){
        issue.createIssue(); issue.deleteIssue();
    }
}
