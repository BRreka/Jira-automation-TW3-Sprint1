package com.codecool.testautomationtwweek03.pages.projectpages;

import com.codecool.testautomationtwweek03.pages.base.*;
import org.openqa.selenium.*;

public class ViewAllPage extends BasePage {

    public WebElement findProjectText(String data) {
        return driver.findElement(By.partialLinkText(data));
    }

}
