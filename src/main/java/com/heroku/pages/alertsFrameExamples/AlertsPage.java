package com.heroku.pages.alertsFrameExamples;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    WebElement jsAlertButton;

    public AlertsPage verifyAlertWithClick() {
        click(jsAlertButton);

        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Click for JS Confirm')]")
    WebElement jsConfirmButton;

    public AlertsPage selectResult(String result) {
        click(jsConfirmButton);

        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;

    public AlertsPage verifyResult(String result) {
        Assertions.assertTrue(containsText(confirmResult, result));
        return this;

    }

    @FindBy(xpath = "//ul/li[3]/button")
    WebElement promptButton;

    public AlertsPage clickOnPromptButton() {
        click(promptButton);
        return this;
    }


    public AlertsPage sendMessage(String message) {
        Alert alert = driver.switchTo().alert(); //This line switches the WebDriver's focus to the alert
        // and assigns the alert to a local variable alert. This is necessary because
        // the sendMessage method needs to interact with the alert directly.
        alert.sendKeys(message);
        alert.accept();
        return this;
    }

    @FindBy(id = "result")
    WebElement result;


    public AlertsPage verifyMessage(String message) {
        Assertions.assertTrue(containsText(result, message));
        return this;
    }
}
