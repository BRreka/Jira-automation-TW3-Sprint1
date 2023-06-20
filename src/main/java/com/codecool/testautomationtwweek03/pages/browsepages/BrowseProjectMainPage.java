package com.codecool.testautomationtwweek03.pages.browsepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowseProjectMainPage {
    WebDriver driver;
    /*
    @FindBy(linkText = "Main Testing Project")
    private WebElement mainTestingProjectTitle;

     */

    @FindBy(xpath = "//a[text()='Main Testing Project']")
    private WebElement mainTestingProjectTitle;

    public BrowseProjectMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //this.driver = util...
        //basepage - konstruktorába ezt (driverbeállítás)
    }

    public boolean isMainTestingProjectTitleDisplayed() {
        return mainTestingProjectTitle.isDisplayed();
    }

    public void clickTitle() {
        mainTestingProjectTitle.click();
    }
}
