package com.codecool.testautomationtwweek03.init;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    private static volatile Properties properties;

    private PropertiesUtil() {}

    public static Properties getInstance() {
        Properties prop = properties;
        if(prop == null) {
            synchronized (PropertiesUtil.class) {
                prop = properties;
                if(prop == null) {
                    prop = new Properties();
                    try {
                        FileInputStream ip = new FileInputStream("config.properties path");
                        prop.load(ip);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return prop;
    }
}
