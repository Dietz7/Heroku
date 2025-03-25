package com.heroku.tests.sliderExample;

import com.heroku.pages.HomePage;
import com.heroku.pages.sliderExample.SliderPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SliderTests extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToHorizontalSlider();
    }

    @Test
    public void sliderTest() {
    new SliderPage(driver).moveSliderToHorizontalId()
            .verifySliderValue("5");
    }
}
