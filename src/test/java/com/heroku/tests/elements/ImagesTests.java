package com.heroku.tests.elements;

import com.heroku.pages.HomePage;
import com.heroku.pages.elements.ImagesPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ImagesTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToBrokenImages();
    }

    @Test
    public void getBrokenImagesTest() {
      new ImagesPage(driver).verifyBrokenImages();
    }


}
