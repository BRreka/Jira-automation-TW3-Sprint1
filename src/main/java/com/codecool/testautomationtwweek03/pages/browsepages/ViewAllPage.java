package com.codecool.testautomationtwweek03.pages.browsepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewAllPage {
    WebDriver driver;
    private By toucan = By.partialLinkText("TOUCAN");
    private By jeti = By.partialLinkText("JETI");
    private By coala = By.partialLinkText("COALA");

    public ViewAllPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isToucanProjectHere() {
        return driver.findElement(toucan).isDisplayed();
    }

    public boolean isJetiProjectHere() {
        return driver.findElement(jeti).isDisplayed();
    }

    public boolean isCoalaProjectHere() {
        return driver.findElement(coala).isDisplayed();
    }

}
