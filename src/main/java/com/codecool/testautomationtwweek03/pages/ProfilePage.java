package com.codecool.testautomationtwweek03.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"up-d-username\"]")
    private WebElement currUserName;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getUsernameFromProfile(){
        return currUserName.getText();
    }
}
