package com.codecool.testautomationtwweek03.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
   public static  WebDriverWait dWait;

   public static WebElement waitForElementToLoad(WebDriver driver, WebElement element){ //rename
       return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
   }
   // public static WebElement notExist(WebDriver driver, WebElement element){
    //    return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.ele);
        //selenium wait for element to not exist
   // }
}
