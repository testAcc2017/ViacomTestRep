package com.epam.tests;

import com.epam.driver.DriverFactory;
import com.epam.driver.ThreadLocalDriver;
import com.epam.listeners.RetryAnalyzer;
import com.epam.pages.AutoSearch;
import com.epam.pages.MainPage;
import org.openqa.selenium.By;
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
    private MainPage page;

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void driverInit(String browser, String platform) throws MalformedURLException {
        driver = ThreadLocalDriver.getWebDriver(browser, platform);
        driver.get(WEB_URL);
        page = new MainPage(driver);
    }

    /*@Test
    public void modelSearch(){
        MainPage page = new MainPage(driver);
        AutoSearch autoSearchPage = page.autoSearchButtonClick();
        autoSearchPage.chooseAutoFromSearchList("audi");
    }*/

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void retryFailureMethodTest() {
        System.out.println("this is  " + number + " try");
        number++;
        Assert.assertEquals(number, 2, "Number is not matched");
    }

    @Test
    public void titleCheckTest() {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("onliner.by"));
    }

    @Test
    public void newsLinkCheckTest() {
        page.newsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.onliner.by/");
    }

    @Test
    public void catalogLinkCheckTest() {
        page.catalogLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://catalog.onliner.by/");
    }

    @Test
    public void baraholkaLinkCheckTest() {
        page.avtobaraholkaLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://ab.onliner.by/");
    }

    @Test
    public void housesAndFlatsLinkCheckTest() {
        page.housesAndFlatsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://r.onliner.by/pk/");
    }

    @Test
    public void serviceLinkCheckTest() {
        page.servicesLink.click();
        Assert.assertEquals(driver.getTitle(), "Onliner. Услуги");
    }

    @Test
    public void forumLinkCheckTest() {
        page.forumLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://forum.onliner.by/");
    }

    @AfterClass
    public void terminateDriver() {
        driver.quit();
        driver = null;
        page = null;
    }
}
