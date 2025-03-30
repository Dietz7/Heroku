package com.heroku.pages;

import com.heroku.config.BasePage;
import com.heroku.pages.alertsFrameExamples.AlertsPage;
import com.heroku.pages.alertsFrameExamples.BrowserWindowsPage;
import com.heroku.pages.alertsFrameExamples.IframePage;
import com.heroku.pages.dropList.DropListPage;
import com.heroku.pages.elements.ButtonPage;
import com.heroku.pages.forms.PracticeFormPage;
import com.heroku.pages.interactions.DragandDropPage;
import com.heroku.pages.sliderExample.SliderPage;
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

    @FindBy(css = "[href='/dropdown']")
    WebElement dropDown;

    public DropListPage navigateToDropDown() {
        click(dropDown);
        return new DropListPage(driver);
    }

    @FindBy(css="[href='/horizontal_slider']")
    WebElement horizontalSlider;
    public SliderPage navigateToHorizontalSlider() {
        click(horizontalSlider);
        return new SliderPage(driver);
    }
    @FindBy(css="[href='/drag_and_drop']")
    WebElement dragDrop;

    public DragandDropPage navigateToDrapAndDrag() {
        click(dragDrop);
        return new DragandDropPage(driver);
    }

    @FindBy(css="[href='/context_menu']")
    WebElement contextMenu;

    public ButtonPage navigateToContextMenu() {
        click(contextMenu);
        return new ButtonPage(driver);
    }

    @FindBy(css="[href='/upload']")
    WebElement upload;

    public PracticeFormPage navigateToFileUpload() {
        click(upload);
        return new PracticeFormPage(driver);
    }


}
