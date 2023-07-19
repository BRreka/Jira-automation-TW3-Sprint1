package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.util.WaitUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.*;

public class LoginPage extends BasePage {
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

    @Override
    public void manageDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
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
        WaitUtil.waitUntilClickable(driver, logoutOption);
        return logoutOption.isDisplayed();
    }

    public void clickLogout() {
        logoutOption.click();
    }

    public void loginToJira(String strUsername, String strPassword) {
        manageDriver();
        setUserName(strUsername);
        setPassword(strPassword);
        clickLogin();
    }

}
