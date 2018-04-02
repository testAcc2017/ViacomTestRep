package com.epam.tests;

import com.epam.driver.DriverFactory;
import com.epam.driver.ThreadLocalDriver;
import com.epam.listeners.RetryAnalyzer;
import com.epam.pages.AutoSearch;
import com.epam.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class OnlinerTest {

    private static final String WEB_URL = "https://www.onliner.by/";
    private static int number = 0;
    private WebDriver driver;


    @BeforeClass
    @Parameters({ "browser", "platform" })
    public void driverInit(String browser, String platform) throws MalformedURLException {
        driver = DriverFactory.getWebdriver(browser, platform);
        ThreadLocalDriver.setWebDriver(driver);
        driver = ThreadLocalDriver.getWebDriver();
        driver.get(WEB_URL);
    }

    /*@Test
    public void titleCheckTest(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("onliner.by"));
    }*/

    @Test
    public void modelSearch(){
        MainPage page = new MainPage(driver);
        AutoSearch autoSearchPage = page.autoSearchButtonClick();
        autoSearchPage.chooseAutoFromSearchList("audi");

    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void retryFailureMethodTest() {
        System.out.println("this is  " + number + " try");
        number++;
        Assert.assertEquals(number, 2, "Number is not matched");

    }

    @AfterClass
    public void terminateDriver() {
        driver.quit();
        driver = null;
    }
}
