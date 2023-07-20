package com.codecool.testautomationtwweek03.util;

import com.codecool.testautomationtwweek03.pages.base.*;

public class NavigateUtil extends BasePage {
    public static void navigateToPage(String url) {
        driver.navigate().to(url);
    }
}
