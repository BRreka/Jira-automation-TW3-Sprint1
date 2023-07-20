package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.pages.base.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ProfilePage extends BasePage implements Manage {
    @FindBy(xpath = "//*[@id=\"up-d-username\"]")
    private WebElement currUserName;

    @Override
    public void manageDriver() {
        driver.get(baseUrl + "ViewProfile.jspa");
    }

    public String getUsernameFromProfile(){
        return currUserName.getText();
    }
}
