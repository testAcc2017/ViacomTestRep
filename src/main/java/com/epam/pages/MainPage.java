package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy (xpath = "//a[@href = 'https://ab.onliner.by' and @class = 'b-main-navigation__link']/span")
    private WebElement autosearch;

    public MainPage(WebDriver driver){
        super(driver);
    }

    public AutoSearch autoSearchButtonClick(){
        autosearch.click();
        return new AutoSearch(getDriver());
    }
}
