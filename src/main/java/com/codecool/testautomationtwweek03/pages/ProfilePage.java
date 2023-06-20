package com.codecool.testautomationtwweek03.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
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
