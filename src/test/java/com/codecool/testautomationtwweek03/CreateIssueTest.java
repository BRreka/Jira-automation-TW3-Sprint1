package com.codecool.testautomationtwweek03;

import com.codecool.testautomationtwweek03.util.*;
import com.codecool.testautomationtwweek03.pages.*;
import org.junit.jupiter.api.*;

import java.util.*;

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
