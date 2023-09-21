package com.codecool.testautomationtwweek03.pages.projectpages;

import com.codecool.testautomationtwweek03.pages.base.*;
import org.openqa.selenium.*;

public class BrowseProjectMainPage extends BasePage {

    public WebElement getProjectTitle(String title) {
        return driver.findElement(By.linkText(title));
    }

}
