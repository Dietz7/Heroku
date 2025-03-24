package com.heroku.tests.dropList;

import com.heroku.pages.HomePage;
import com.heroku.pages.dropList.DropListPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropDownListTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToDropDown();
        new DropListPage(driver).selectDropDownList();
    }

    @Test
    public void selectOption1Test(){
        new DropListPage(driver).selectOption1("1")
                .verifyNumber("1");
    }

    @Test
    public void selectOption2Test(){
        new DropListPage(driver).selectOption2("2")
                .verifyNumber("2");

    }
}
