package com.heroku.tests.alertsFrameExamples;

import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameExamples.BrowserWindowsPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BrowserWindowsTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectMultipleWindows();
    }

    @Test
    @Tag("smoke")
    public void switchToNewTabTest() {
        new BrowserWindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("New Window");

    }

}
