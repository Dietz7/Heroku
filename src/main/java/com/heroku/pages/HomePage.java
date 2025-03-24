package com.heroku.pages;

import com.heroku.config.BasePage;
import com.heroku.pages.alertsFrameExamples.AlertsPage;
import com.heroku.pages.alertsFrameExamples.BrowserWindowsPage;
import com.heroku.pages.alertsFrameExamples.IframePage;
import com.heroku.pages.dropList.DropListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href = '/javascript_alerts']")
    WebElement alertsExamples;

    public AlertsPage selectJavaScriptAlerts() {
        click(alertsExamples);
        return new AlertsPage(driver);

    }

    @FindBy(css = "[href='/frames']")
    WebElement frames;

    public IframePage selectFrames() {
        click(frames);
        return new IframePage(driver);
    }

    @FindBy(css = "[href= '/windows']")
    WebElement windows;

    public BrowserWindowsPage selectMultipleWindows() {
        click(windows);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(css="[href='/dropdown']")
    WebElement dropDown;
    public DropListPage navigateToDropDown() {
        click(dropDown);
        return new DropListPage(driver);
    }
}
