package com.epam.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private WebDriver driver;
    private static final String HUB_URL = "http://localhost:4444/wd/hub";
    private static final String APPIUM_HUB_URL = "http://localhost:4723/wd/hub";

    public WebDriver getWebdriver(String browser, String platform) throws MalformedURLException {
        if ("android".equalsIgnoreCase(platform)) {
            driver = selectAndroidDriver(browser, platform);
        } else {
            driver = selectRemoteDriver(browser, platform);
        }
        return driver;
    }

    private WebDriver selectRemoteDriver(String browser, String platform) throws MalformedURLException {
        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setCapability(platform, Platform.fromString(platform));
                driver = new RemoteWebDriver(new URL(HUB_URL), ffOptions);
                driver.manage().window().maximize();
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(platform, Platform.fromString(platform));
                driver = new RemoteWebDriver(new URL(HUB_URL), chromeOptions);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }

    private WebDriver selectAndroidDriver(String browser, String platform) throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("autoWebview", "true");
        capability.setCapability("device", "");
        capability.setCapability(CapabilityType.BROWSER_NAME, browser);
        capability.setCapability(CapabilityType.BROWSER_VERSION, "65.0");
        capability.setCapability("deviceName", "09960f6f");
        capability.setCapability("platformName", platform.toUpperCase());
        capability.setCapability("platformVersion","4.4.2");
        return driver = new RemoteWebDriver(new URL(APPIUM_HUB_URL), capability);
    }

}
