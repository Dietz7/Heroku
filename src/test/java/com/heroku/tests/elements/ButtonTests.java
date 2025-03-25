package com.heroku.tests.elements;

import com.heroku.pages.HomePage;
import com.heroku.pages.elements.ButtonPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ButtonTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToContextMenu();
    }


    @Test
    public void rightClickOnHotSpotTest() {
        new ButtonPage(driver).rightClickOnHotSpot()
                .verifyRightClick("You selected a context menu");
    }
}

