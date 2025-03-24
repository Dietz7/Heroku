package com.heroku.tests.alertsFrameExamples;

import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameExamples.AlertsPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsTests extends TestBase {

    AlertsPage alert;

    @BeforeEach
    public void precondition() {
        alert = new AlertsPage(driver);
        new HomePage(driver).selectJavaScriptAlerts();
    }

    @Test
    @DisplayName("Verify to - Alert is appeared and clicked")
    public void successfulClickAnAlert() {
        alert.verifyAlertWithClick();
    }

    @Test
    @DisplayName("Verify to - 'Cancel' is displayed")
    public void cancelAlertTest() {
        alert.selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to - 'The message is displayed'")
    public void sendMessageToAlertTest() {
        alert.clickOnPromptButton()
                .sendMessage("Hello World!")
                .verifyMessage("Hello World");

    }
}
