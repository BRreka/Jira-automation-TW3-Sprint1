package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.PropertiesUtil;
import com.codecool.testautomationtwweek03.util.WebdriverUtil;
import com.codecool.testautomationtwweek03.pages.CreateIssue;
import com.codecool.testautomationtwweek03.pages.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CreateIssueTest {
    CreateIssue issue;
    LoginPage loginPage;
    static Properties properties;

    @BeforeEach
    public void setUp() {
        properties = PropertiesUtil.getInstance();
        loginPage = new LoginPage();
        issue = new CreateIssue();
        loginPage.loginToJira(properties.getProperty("username"), properties.getProperty("password"));
    }
    @Test
    public void createIssueTest(){
        issue.createIssue(); issue.deleteIssue();
    }
}
