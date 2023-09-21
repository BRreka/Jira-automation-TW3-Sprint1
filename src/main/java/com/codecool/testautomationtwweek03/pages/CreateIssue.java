package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.pages.base.*;
import com.codecool.testautomationtwweek03.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CreateIssue extends BasePage {
    @FindBy(id = "create_link")
    private WebElement create;
    @FindBy(id = "project-field")
    private WebElement project;
    @FindBy(id = "issuetype-field")
    private WebElement issueType;
    @FindBy(id = "summary")
    private WebElement summary;
    @FindBy(id = "create-issue-submit")
    private WebElement createIssueSubmit;

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
    public void createIssue(String projectStr, String issueTypeStr, String summaryStr) {


        create.click();

        enterData(projectStr, issueTypeStr, summaryStr);

        getCookieToConsole();
        editCookie();

        createIssueSubmit.click();

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

    private void enterData(String projectStr, String issueTypeStr, String summaryStr) {
        WaitUtil.waitUntilClickable(driver, project).click();
        project.sendKeys(projectStr + Keys.TAB);
        try {
            WaitUtil.waitUntilClickable(driver, issueType).click();

        } catch (StaleElementReferenceException e) {
            WaitUtil.waitUntilClickable(driver, issueType).click();
        }

        issueType.sendKeys(issueTypeStr + Keys.TAB);

        try {
            WaitUtil.waitUntilClickable(driver, summary).sendKeys(summaryStr);
        } catch (StaleElementReferenceException e) {
            WaitUtil.waitUntilClickable(driver, summary).sendKeys(summaryStr);
        }
    }
}
