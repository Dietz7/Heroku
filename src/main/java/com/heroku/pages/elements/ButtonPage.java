package com.heroku.pages.elements;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonPage extends BasePage {
    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hotSpot;

    public ButtonPage rightClickOnHotSpot() {
        new Actions(driver).contextClick(hotSpot).perform();
        return this;
    }

    public ButtonPage verifyRightClick(String expText) {
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals(expText, alert.getText());
        alert.accept();
        return this;
    }
}
