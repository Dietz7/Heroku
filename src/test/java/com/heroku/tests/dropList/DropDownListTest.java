package com.heroku.tests.dropList;

import com.heroku.pages.HomePage;
import com.heroku.pages.dropList.DropListPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DropDownListTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToDropDown();
        new DropListPage(driver).selectDropDownList();
    }

    @Test
    @Tag("smoke")
    public void selectOptionTest(){
        new DropListPage(driver).selectOptionByValue("2")
                .verifyNumber("2");
    }


}
