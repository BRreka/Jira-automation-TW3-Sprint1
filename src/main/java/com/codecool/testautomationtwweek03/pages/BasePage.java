package com.codecool.testautomationtwweek03.pages;

import com.codecool.testautomationtwweek03.util.PropertiesUtil;
import com.codecool.testautomationtwweek03.util.WebdriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.*;

public abstract class BasePage {
    protected final WebDriver driver = WebdriverUtil.getInstance();
    protected final Properties properties = PropertiesUtil.getInstance();
    protected final String baseUrl = properties.getProperty("baseUrl");

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

    public abstract void manageDriver();

}
