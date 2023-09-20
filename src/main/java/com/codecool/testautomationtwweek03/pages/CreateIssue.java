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
    @FindBy(xpath = "//*[@id='summary']")
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

    @FindBy(xpath = "//*[contains(@class, 'issue-created-key') and contains(@class, 'issue-link')]")
    private WebElement popUpIssue;

    //breaks pom
    @FindBy(id = "opsbar-operations_more")
    private WebElement moreOption;

    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteOption;

    @FindBy(id = "summary-val")
    private WebElement summaryTitle;
    @FindBy(id = "delete-issue-submit")
    private WebElement deleteIssueConfirm;

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

    public void clickOnCreatedIssue() {
        WaitUtil.waitUntilClickable(driver, popUpIssue);
        popUpIssue.click();
    }

    public void clickOnMoreOption() {
        WaitUtil.waitUntilClickable(driver, moreOption);
        moreOption.click();
    }

    public void clickOnDeleteOption() {
        WaitUtil.waitUntilClickable(driver, deleteOption);
        deleteOption.click();
    }
    public String getTextOfSummary() {
        WaitUtil.waitUntilVisible(driver, summaryTitle);
        return summaryTitle.getText();
    }
    private void confirmDelete() {
        WaitUtil.waitUntilClickable(driver, deleteIssueConfirm);
        deleteIssueConfirm.click();
    }
    public void createIssue() {


        getCreateIssue().click();

        enterData();

        getCookieToConsole();
        editCookie();

        createissueSubmt().click();

        getCookieToConsole();
    }

    public void navigateToIssue() {
        clickOnCreatedIssue();
    }
    public void deleteIssue() {
        clickOnMoreOption();
        clickOnDeleteOption();
        confirmDelete();
    }

    private void editCookie() {
        Cookie cookie = driver.manage().getCookieNamed("atlassian.xsrf.token");
        driver.manage().deleteCookie(cookie);
        driver.manage().addCookie(
                new Cookie.Builder(cookie.getName(), cookie.getValue())
                        .domain(cookie.getDomain())
                        .expiresOn(cookie.getExpiry())
                        .path(cookie.getPath())
                        .isSecure(cookie.isSecure())
                        .build()
                );
    }

    private void getCookieToConsole() {
        Cookie cookie = driver.manage().getCookieNamed("atlassian.xsrf.token");
        System.out.println(cookie);
    }

    private void enterData() {
        WaitUtil.waitUntilClickable(driver, getProject()).click();
        getProject().sendKeys("Main Testing Project" + Keys.TAB);
        try {
            WaitUtil.waitUntilClickable(driver, getissueType()).click();

        } catch (StaleElementReferenceException e) {
            WaitUtil.waitUntilClickable(driver, getissueType()).click();
        }

        getissueType().sendKeys("Bug" + Keys.TAB);

        try {
            WaitUtil.waitUntilClickable(driver, getSummary()).sendKeys("Create Issue Test A46");
        } catch (StaleElementReferenceException e) {
            WaitUtil.waitUntilClickable(driver, getSummary()).sendKeys("Create Issue Test A46");
        }
    }
}
