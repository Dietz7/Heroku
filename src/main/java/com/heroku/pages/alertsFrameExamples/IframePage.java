package com.heroku.pages.alertsFrameExamples;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage {
    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//ul/li[2]/a")
    WebElement iFrame;

    public IframePage selectIframe() {
        click(iFrame);
        return new IframePage(driver);
    }



    @FindBy(xpath = "//body[@id='tinymce']/p")
    WebElement content;

    public IframePage verifyClickOniFrame(String text) {
        driver.switchTo().frame(0);
        Assertions.assertTrue(content.getText().contains(text));
        driver.switchTo().defaultContent();
        return this;
    }
}
