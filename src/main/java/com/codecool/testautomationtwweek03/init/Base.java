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
            FileInputStream ip = new FileInputStream("C:\\Users\\bencz\\Documents\\InvisiSh9\\TESTINGPROJECTS\\Test-Automation-TeamW-Week-03\\src\\main\\java\\com\\codecool\\testautomationtwweek03\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
