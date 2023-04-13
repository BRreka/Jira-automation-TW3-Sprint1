package com.codecool.testautomationtwweek03.pages.browsepages.mtp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MTPpage {
    WebDriver driver;
    //pagefactory - webelementet kapunk, nem setupolja egyből
    //leszárbaztatni egy base page-ből //driver, wait, pagefactory
    @FindBy(xpath = "//dd[text()='MTP']")
    private WebElement MTP;

    public MTPpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isMTPKeyPresent() {
        return MTP.isDisplayed();
    }
}
