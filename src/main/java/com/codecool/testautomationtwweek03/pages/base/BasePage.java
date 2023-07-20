package com.codecool.testautomationtwweek03.pages.base;

import com.codecool.testautomationtwweek03.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.*;

public abstract class BasePage {
    protected static final WebDriver driver = WebdriverUtil.getInstance();
    protected final Properties properties = PropertiesUtil.getInstance();
    protected final String baseUrl = properties.getProperty("baseUrl");

    public BasePage() {
        PageFactory.initElements(driver,this);
    }

}
