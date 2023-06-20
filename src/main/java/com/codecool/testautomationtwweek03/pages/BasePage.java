package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.init.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver = WebdriverUtil.getInstance();

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

    public abstract void manageDriverInit();

}
