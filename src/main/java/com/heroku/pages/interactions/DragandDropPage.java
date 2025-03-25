package com.heroku.pages.interactions;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragandDropPage extends BasePage {

    public DragandDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="column-a")
    WebElement columnA;

    @FindBy(id="column-b")
    WebElement columnB;

    public DragandDropPage actionDragMe() {
        new Actions(driver).dragAndDrop(columnA, columnB).perform();
        return this;
    }

    public DragandDropPage verifyDropped(String text) {
        Assertions.assertTrue(containsText(columnB, text));
        return this;
    }
}
