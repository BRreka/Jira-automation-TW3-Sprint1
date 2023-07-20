package com.codecool.testautomationtwweek03.pages.projectpages;

import com.codecool.testautomationtwweek03.pages.base.*;
import org.openqa.selenium.*;

public class BrowseProjectMainPage extends BasePage {

    //@FindBy(xpath = "//a[text()='Main Testing Project']")
    //private WebElement mainTestingProjectTitle;

    public WebElement getProjectTitle(String title) {
        return driver.findElement(By.linkText(title));
    }

    /*

    public boolean isMainTestingProjectTitleDisplayed() {
        return mainTestingProjectTitle.isDisplayed();
    }

    public void clickTitle() {
        mainTestingProjectTitle.click();
    }

     */
}
