package com.epam.onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AutoSearch {
    private WebDriver driver;

    @FindBy(xpath = "//select[@class ='manufacture']")
    private WebElement autoModelDropDownButton;


    public AutoSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AutoSearch chooseAutoFromSearchList(String model){
        autoModelDropDownButton.click();
        dropDownListSelection(model, autoModelDropDownButton);
        return new AutoSearch(driver);
    }

    public AutoSearch dropDownListSelection(String model, WebElement element) {
        Select select = new Select(element);

        select.selectByValue(model);
        return new AutoSearch(driver);
    }

}
