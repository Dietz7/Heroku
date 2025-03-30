package com.heroku.config;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this); // initialisation of the page and methods
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean containsText(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public boolean isAlertPresent(int time) {
        Alert alert = wait(time) //new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        driver.switchTo().alert();
        alert.accept();
        return true;
    }

    public WebDriverWait wait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void switchToNextWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return wait(time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(WebElement element, String value) {
        return element.getDomAttribute(value);
    }
}
