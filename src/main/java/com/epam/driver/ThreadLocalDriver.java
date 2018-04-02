package com.epam.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class ThreadLocalDriver {
    private static ThreadLocal<WebDriver> webDriver  = new ThreadLocal<WebDriver>();

    public static WebDriver getWebDriver(String browser, String platform) throws MalformedURLException {
        setWebDriver(browser, platform);
        return webDriver.get();

    }

    private static void setWebDriver(String browser, String platform) throws MalformedURLException {
        if (webDriver.get() == null) {
            webDriver.set(DriverFactory.getWebdriver(browser, platform));
        }
    }


}
