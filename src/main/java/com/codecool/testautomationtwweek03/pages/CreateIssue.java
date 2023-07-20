package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.pages.base.*;
import com.codecool.testautomationtwweek03.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;

public class CreateIssue extends BasePage {
    @FindBy(xpath = "//*[@id=\"create_link\"]")
    private WebElement create;
    @FindBy(xpath = "//*[@id=\"project-field\"]")
    private WebElement project;
    @FindBy(xpath = "//*[@id=\"issuetype-field\"]")
    private WebElement issueType;
    @FindBy(xpath = "//*[@id=\"issuetype-field\"]")
    private WebElement summary;
    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    private WebElement desc;

    // private final By issueType = By.id("issuetype-field");
    @FindBy(xpath = "//*[@id=\"priority-field\"]")
    private WebElement prio;
    @FindBy(xpath = "//*[@id=\"assignee-field\"]")
    private WebElement assignee;
    @FindBy(xpath = "//*[@id=\"create-issue-submit\"]")
    private WebElement submit;
    @FindBy(xpath = "//*[@id=\"opsbar-operations_more\"]")
    private WebElement more;
    @FindBy(xpath = "//*[@id=\"opsbar-operations_more\"]")
    private WebElement delete;
    @FindBy(xpath = "//*[@id=\"opsbar-operations_more\"]")
    private WebElement delsub;

    public WebElement getCreateIssue() {
        return create;
    }

    public WebElement getProject() {
        return project;

    }

    public WebElement getissueType() {
        return issueType;
    }

    public WebElement getSummary() {
        return summary;
    }

    public WebElement newissueDescription() {
        return desc;
    }

    public WebElement getPrio() {
        return prio;
    }

    public WebElement getAssignee() {
        return assignee;
    }

    public WebElement createissueSubmt() {
        return submit;
    }

    public WebElement deleissueSubmt() {
        return delsub;
    }

    public WebElement deleteIssues() {
        return delete;
    }

    public WebElement moreFind() {
        return more;
    }

    public void createIssue() {


        getCreateIssue().click();

        WaitUtil.waitUntilClickable(driver, getProject()).click();
        getProject().sendKeys("Main Testing Project" + Keys.TAB);
        try {
            WaitUtil.waitUntilClickable(driver, getissueType()).click();

        } catch (StaleElementReferenceException e) {
            WaitUtil.waitUntilClickable(driver, getissueType()).click();
        }

        getissueType().sendKeys("Bug" + Keys.TAB);


        try{  WaitUtil.waitUntilClickable(driver, getSummary()).click();}catch (StaleElementReferenceException e){
            WaitUtil.waitUntilClickable(driver, getSummary()).click();
        }
        getSummary().sendKeys("Test automation tw 3 green ear monkeys");

        createissueSubmt().click();
    }

    public void deleteIssue() {
        Actions actions = new Actions(driver);
        WebElement moreButton = WaitUtil.waitUntilClickable(driver, moreFind());
        actions.moveToElement(moreButton).click().build().perform();
        WaitUtil.waitUntilClickable(driver, deleteIssues()).click();
        WaitUtil.waitUntilClickable(driver, deleissueSubmt()).click();
    }

}
