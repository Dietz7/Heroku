package com.heroku.pages.alertsFrameExamples;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/windows/new']")
    WebElement windowsNew;
    public BrowserWindowsPage switchToNewTab(int index) {
        click(windowsNew);
        switchToNextWindow(index);
        return this;
    }

    @FindBy(xpath = "//div[@class='example']/h3[text()='New Window']")
    private WebElement newWindow;

    public BrowserWindowsPage verifyNewTabTitle(String expText) {
        Assertions.assertTrue(shouldHaveText(newWindow, expText, 5));
        return this;
    }
}
