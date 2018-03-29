package com.epam.onliner;

import com.epam.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class OnlinerTest {

    private static final String WEB_URL = "https://www.onliner.by/";
    private WebDriver driver;
    private int number = 0;

    @BeforeClass
    @Parameters({ "browser", "platform" })
    public void driverInit(String browser, String platform) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getWebdriver(browser, platform);
        driver.get(WEB_URL);
    }

    @Test
    public void titleCheck(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("onliner.by"));
    }

    @Test
    public void retryFailureMethodTest() {
        System.out.println("this is  " + number + " try");
        Assert.assertTrue(false);
        number++;
    }

    @AfterClass
    public void terminateDriver() {
        driver.quit();
        driver = null;
    }
}
