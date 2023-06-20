package com.codecool.testautomationtwweek03.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.time.*;
import java.util.*;

public class Base {

    public WebDriver driver;
    public Properties prop;
    public String path;

    public Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("config.properties path");
            prop.load(ip);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
        //java maven resources - read property file ?

        // how to put application to the path (w / mac) - webdrivert a path-ba
        // terminál chromedriver --version / ekkor van benne a pathban
        //mac - bash rc // win system property
    }

    public WebDriver initDriver() {
        path = prop.getProperty("driverPath");
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
        return driver;
    }
}
