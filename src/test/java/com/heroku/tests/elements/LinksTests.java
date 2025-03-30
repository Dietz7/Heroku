package com.heroku.tests.elements;

import com.heroku.pages.HomePage;
import com.heroku.pages.elements.LinksPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinksTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToStatusCodes();
    }
    @Test
    public void statusCodesTest(){
        new LinksPage(driver).checkValidityOfLinksWithoutClick()
                .verifyBrokenLinks();
    }
}
