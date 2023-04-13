package com.codecool.testautomationtwweek03.pages.browsepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAllPage {
    WebDriver driver;
    @FindBy(partialLinkText = "TOUCAN")
    private WebElement toucan;
    @FindBy(partialLinkText = "JETI")
    private WebElement jeti;
    @FindBy(partialLinkText = "COALA")
    private WebElement coala;

    public ViewAllPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isToucanProjectHere() {
        return toucan.isDisplayed();
    }

    public boolean isJetiProjectHere() {
        return jeti.isDisplayed();
    }

    public boolean isCoalaProjectHere() {
        return coala.isDisplayed();
    }

}
