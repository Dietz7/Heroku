package com.heroku.pages.dropList;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropListPage extends BasePage {

    public DropListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="dropdown")
    WebElement dropDown;

    public DropListPage selectDropDownList() {
        return this;
    }

    @FindBy(xpath="//option[@value='1']")
    WebElement option1;

    @FindBy(xpath="//option[@value='2']")
    WebElement option2;

    public DropListPage selectOptionByValue(String value) {
        Select select = new Select(dropDown);
        select.selectByValue(value);
        return this;
    }

    public DropListPage verifyNumber(String expValue) {
        Select select = new Select(dropDown);
        String selectedValue = select.getFirstSelectedOption().getAttribute("value"); // Use value attribute instead of text
        Assertions.assertEquals(expValue, selectedValue, "Selected value does not match the expected value attribute.");
        return this;
    }

}
