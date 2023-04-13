package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.init.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class CreatIssue {
    WebDriver driver;
    Utility util;
    private final By create = By.xpath("//*[@id=\"create_link\"]");
    private final By project = By.xpath("//*[@id=\"project-field\"]");
    private final By issueType = By.xpath("//*[@id=\"issuetype-field\"]");

    private final By summary = By.xpath("//*[@id=\"summary\"]");
    private final By desc = By.xpath("//*[@id=\"tinymce\"]/p");
    // private final By issueType = By.id("issuetype-field");
    private final By prio = By.xpath("//*[@id=\"priority-field\"]");
    private final By assignee = By.xpath("//*[@id=\"assignee-field\"]");
    private final By submit = By.xpath("//*[@id=\"create-issue-submit\"]");
    private final By more = By.xpath("//*[@id=\"opsbar-operations_more\"]");
    private final By delete = By.xpath("//*[@id=\"delete-issue\"]");
    private final By delsub = By.xpath("//*[@id=\"delete-issue-submit\"]");

    public CreatIssue(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCreateIssue() {
        return driver.findElement(create);
    }

    public WebElement getProject() {
        return driver.findElement(project);

    }

    public WebElement getissueType() {
        return driver.findElement(issueType);
    }

    public WebElement getSummary() {
        return driver.findElement(summary);
    }

    public WebElement newissueDescription() {
        return driver.findElement(desc);
    }

    public WebElement getPrio() {
        return driver.findElement(prio);
    }

    public WebElement getAssignee() {
        return driver.findElement(assignee);
    }

    public WebElement createissueSubmt() {
        return driver.findElement(submit);
    }

    public WebElement deleissueSubmt() {
        return driver.findElement(delsub);
    }

    public WebElement deleteIssues() {
        return driver.findElement(delete);
    }

    public WebElement moreFind() {
        return driver.findElement(more);
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
