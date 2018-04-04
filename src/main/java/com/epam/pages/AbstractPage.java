package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Каталог']")
    public WebElement catalogLink;
    @FindBy(xpath = "//a[@href = 'https://www.onliner.by' and @class = 'b-main-navigation__link']/span")
    public WebElement newsLink;
    @FindBy(xpath = " //ul[@class='b-main-navigation']/li[4]//span")
    public WebElement housesAndFlatsLink;
    @FindBy(xpath = " //a[@href = 'https://s.onliner.by']/span")
    public WebElement servicesLink;
    @FindBy(xpath = "//a[contains(@href, 'https://ab.onliner.by') and @class = 'b-main-navigation__link']/span")
    public WebElement avtobaraholkaLink;
    @FindBy(xpath = "//a[contains(@href, 'https://forum.onliner.by') and @class = 'b-main-navigation__link']/span")
    public WebElement forumLink;


    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

}
