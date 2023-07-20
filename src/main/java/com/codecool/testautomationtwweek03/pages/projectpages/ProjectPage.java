package com.codecool.testautomationtwweek03.pages.projectpages;

import com.codecool.testautomationtwweek03.pages.base.*;
import org.openqa.selenium.*;

public class ProjectPage extends BasePage {

    public WebElement getProjectKey(String key) {
        return driver.findElement(By.xpath("//dd[text()='" + key + "']"));
    }
/*
    public boolean isMTPKeyPresent() {
        return MTP.isDisplayed();
    }

 */
}
