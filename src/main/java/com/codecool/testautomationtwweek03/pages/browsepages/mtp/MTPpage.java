package com.codecool.testautomationtwweek03.pages.browsepages.mtp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MTPpage {

    WebDriver driver;
    //pagefactory - webelementet kapunk, nem setupolja egyből
    //leszárbaztatni egy base page-ből //driver, wait, pagefactory
    private By MTP = By.xpath("//dd[text()='MTP']");

    public MTPpage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMTPKeyPresent() {
        return driver.findElement(MTP).isDisplayed();
    }
}
