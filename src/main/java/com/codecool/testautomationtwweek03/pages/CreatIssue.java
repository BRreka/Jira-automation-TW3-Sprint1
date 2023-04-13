package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.init.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreatIssue {
    WebDriver driver;
    Utility util;
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

    public CreatIssue(WebDriver driver) {
        this.driver = driver;
    }

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

        Utility.waitForElementToLoad(driver, getProject()).click();
        getProject().sendKeys("Main Testing Project" + Keys.TAB);
        try {
            Utility.waitForElementToLoad(driver, getissueType()).click();

        } catch (StaleElementReferenceException e) {
            Utility.waitForElementToLoad(driver, getissueType()).click();
        }

        getissueType().sendKeys("Bug" + Keys.TAB);


        try{  Utility.waitForElementToLoad(driver, getSummary()).click();}catch (StaleElementReferenceException e){
            Utility.waitForElementToLoad(driver, getSummary()).click();
        }
        getSummary().sendKeys("Test automation tw 3 green ear monkeys");


        //  getPrio().click();
        //getPrio().sendKeys("Low" + Keys.TAB);
        // getAssignee().sendKeys("Automation47");
        createissueSubmt().click();
    }

    public void deleteIssue() {
        Actions actins = new Actions(driver);
        WebElement moreButton = Utility.waitForElementToLoad(driver, moreFind());
        actins.moveToElement(moreButton).click().build().perform();
        Utility.waitForElementToLoad(driver, deleteIssues()).click();
        Utility.waitForElementToLoad(driver, deleissueSubmt()).click();

    }
}
