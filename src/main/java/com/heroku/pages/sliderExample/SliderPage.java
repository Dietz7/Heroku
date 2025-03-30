package com.heroku.pages.sliderExample;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="input[type='range']")
    WebElement sliderContainer;

    @FindBy(id="range")
    WebElement sliderValue;
    public SliderPage moveSliderToHorizontalId() {
        pause(100);
        new Actions(driver).dragAndDropBy(sliderContainer, 230, 0).perform();
        return this;
    }

    public SliderPage verifySliderValue(String number) {
        String actualValue = sliderValue.getText();
        System.out.println("Slider current value: " + actualValue);
        Assertions.assertEquals(number, actualValue);
        return this;
    }
}
