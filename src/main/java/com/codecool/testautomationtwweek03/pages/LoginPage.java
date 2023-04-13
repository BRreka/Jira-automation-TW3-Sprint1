package com.codecool.testautomationtwweek03.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private final By username = By.id("login-form-username");
    private final By password = By.id("login-form-password");
    private final By loginButton = By.id("login-form-submit");
    private final By errorMessage = By.xpath("//*[@id=\"login-form\"]/div[1]/div[1]/p");
    private final By profileMenu = By.id("user-options");
    private final By logoutOption = By.id("log_out");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String strUserName) {
        driver.findElement(username).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickProfileMenu() {
        driver.findElement(profileMenu).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public WebElement findLogout() {
        //Kinnick szerint ez felesleges
        // a logut miatt at kell irnom
        return driver.findElement(logoutOption);
    }

    public void loginToJira(String strUsername, String strPassword) {
        this.setUserName(strUsername);
        this.setPassword(strPassword);
        this.clickLogin();
    }

}
