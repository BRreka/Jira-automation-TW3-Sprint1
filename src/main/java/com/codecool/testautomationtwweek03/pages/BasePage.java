package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.init.PropertiesUtil;
import com.codecool.testautomationtwweek03.init.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.time.Duration;
import java.util.Properties;

public abstract class BasePage {
    protected final WebDriver driver = WebdriverUtil.getInstance();
    protected final Properties properties = PropertiesUtil.getInstance();

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

    public abstract void manageDriverInit();

}
