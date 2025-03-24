package com.heroku.tests.alertsFrameExamples;

import com.heroku.pages.HomePage;
import com.heroku.pages.alertsFrameExamples.IframePage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IframesTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).selectFrames();
    }

    @Test
    public void selectIframeTest() {
        new IframePage(driver).selectIframe()
                .verifyClickOniFrame("Your content goes here.");
    }
}
