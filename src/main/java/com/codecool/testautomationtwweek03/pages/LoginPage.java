package com.codecool.testautomationtwweek03.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id = "login-form-username")
    private WebElement username;
    @FindBy(id = "login-form-password")
    private WebElement password;
    @FindBy(id = "login-form-submit")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/div[1]/p")
    private WebElement errorMessage;
    @FindBy(id = "user-options")
    private WebElement profileMenu;
    @FindBy(id = "log_out")
    private WebElement logoutOption;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUserName) {
        username.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickProfileMenu() {
        profileMenu.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean findLogout() {
        return logoutOption.isDisplayed();

    }

    public void clickLogout() {
        logoutOption.click();
    }

    public void loginToJira(String strUsername, String strPassword) {
        this.setUserName(strUsername);
        this.setPassword(strPassword);
        this.clickLogin();
    }

}
