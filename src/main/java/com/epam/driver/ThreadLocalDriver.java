package com.epam.driver;

import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {
    private static ThreadLocal<WebDriver> webDriver  = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        if (webDriver.get() == null) {
            webDriver.set(driver);
        }
    }
}
