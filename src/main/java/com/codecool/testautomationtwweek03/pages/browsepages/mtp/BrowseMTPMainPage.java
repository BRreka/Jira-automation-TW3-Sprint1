package com.codecool.testautomationtwweek03.pages.browsepages.mtp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowseMTPMainPage {
    WebDriver driver;
    private final By mainTestingProjectTitle = By.linkText("Main Testing Project");

    public BrowseMTPMainPage(WebDriver driver) {
        this.driver = driver;
        //this.driver = util...
        //basepage - konstruktorába ezt (driverbeállítás)
    }

    public boolean isMainTestingProjectTitleDisplayed() {
        return driver.findElement(mainTestingProjectTitle).isDisplayed();
    }

    public void clickTitle() {
        driver.findElement(mainTestingProjectTitle).click();
    }
}
