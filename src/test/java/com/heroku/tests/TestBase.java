package com.heroku.tests;

import com.heroku.config.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    public WebDriver driver;

    @BeforeEach
    public void init() {
        driver = app.startTest();

    }

    @AfterEach
    public void tearDown() {
        app.stopTest();
    }

}