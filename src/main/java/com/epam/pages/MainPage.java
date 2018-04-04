package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    public MainPage(WebDriver driver){
        super(driver);
    }

    public AutoSearch autoSearchButtonClick(){
        avtobaraholkaLink.click();
        return new AutoSearch(getDriver());
    }
}
