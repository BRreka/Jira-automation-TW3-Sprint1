package com.codecool.testautomationtwweek03.util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.*;

public class WaitUtil {
   public static WebElement waitUntilClickable(WebDriver driver, WebElement element){
       return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
   }
    public static WebElement waitUntilVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
    }

}
