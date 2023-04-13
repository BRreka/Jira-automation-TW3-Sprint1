package com.codecool.testautomationtwweek03.init;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public Properties prop;


    public Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
        //java maven resources - read property file ?

        // how to put application to the path (w / mac) - webdrivert a path-ba
        // terminál chromedriver --version / ekkor van benne a pathban
        //mac - bash rc // win system property
    }
}
