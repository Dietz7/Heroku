package com.heroku.tests.interactions;

import com.heroku.pages.HomePage;
import com.heroku.pages.interactions.DragandDropPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends TestBase {
  @BeforeEach
    public void precondition(){
      new HomePage(driver).navigateToDrapAndDrag();
  }

  @Test
  public void actionDragMeTest(){
    new DragandDropPage(driver).actionDragMe()
            .verifyDropped("A");
  }

}
