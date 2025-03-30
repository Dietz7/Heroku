package com.heroku.pages.elements;

import com.heroku.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksPage checkValidityOfLinksWithoutClick() {
        String url;
        System.out.println("Total links on the page are " + allLinks.size());

        // Loop through the links and print each one
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getAttribute("href"); // Get the 'href' attribute, not the link text
            System.out.println(url);
            System.out.println("**************************************************");
        }

        return this;
    }

    public LinksPage verifyBrokenLinks() {

        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href"); // Get the 'href' attribute
            if (url == null || url.isEmpty()) {
                System.out.println("BROKEN LINK: " + element.getText());
            } else {
                System.out.println("VALID LINK: " + url);
            }
        }
        return this;
    }
}
