package com.codecool.testautomationtwweek03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ProfilePage {
    WebDriver driver;
    private By currUserName = By.xpath("//*[@id=\"up-d-username\"]");
   // Properties prop;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        //this.prop = prop;
    }
    public String getUsernameFromProfile(){
        return driver.findElement(currUserName).getText();
    }
}
