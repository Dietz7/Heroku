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

    public DropListPage selectOption1(String number) {
        return selectOptionByValue(number);
    }

    public DropListPage selectOption2(String number) {
        return selectOptionByValue(number);
    }

    public DropListPage verifyNumber(String expValue) {
        Select select = new Select(dropDown);
        String selectedValue = select.getFirstSelectedOption().getAttribute("value");
        Assertions.assertTrue(selectedValue.equals(expValue), expValue + selectedValue);
        return this;
    }
}
