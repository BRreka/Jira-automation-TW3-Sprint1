package com.codecool.testautomationtwweek03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

import static com.codeborne.selenide.Condition.attribute;

public class LoginTest {

    WebDriver driver;
    Properties properties;
    String path;

    @BeforeEach
    public void setUp() {
        path = properties.getProperty("driverPath");
        System.setProperty("webdriver.chrome.driver",path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void login() {

    }


}
