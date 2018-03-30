package com.epam.onliner;

import com.epam.listeners.RetryAnalyzer;
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
    private static int number = 0;
    private WebDriver driver;


    @BeforeClass
    @Parameters({ "browser", "platform" })
    public void driverInit(String browser, String platform) throws MalformedURLException {
        driver = DriverFactory.getWebdriver(browser, platform);
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
