package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AutoSearch extends AbstractPage{

    @FindBy(xpath = "//select[@class ='manufacture']")
    private WebElement autoModelDropDownButton;


    public AutoSearch(WebDriver driver){
        super(driver);
    }

    public AutoSearch chooseAutoFromSearchList(String model){
        autoModelDropDownButton.click();
        dropDownListSelection(model, autoModelDropDownButton);
        return new AutoSearch(getDriver());
    }

    public AutoSearch dropDownListSelection(String model, WebElement element) {
        Select select = new Select(element);

        select.selectByValue(model);
        return new AutoSearch(getDriver());
    }

}
