package com.epam.onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy (xpath = "//a[@href = 'https://ab.onliner.by' and @class = 'b-main-navigation__link']/span")
    private WebElement autosearch;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AutoSearch autoSearchButtonClick(){
        autosearch.click();
        return new AutoSearch(driver);
    }
}
