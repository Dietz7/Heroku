package com.heroku.pages.elements;

import com.heroku.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ImagesPage extends BasePage {
    public ImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public ImagesPage verifyBrokenImages() {
        System.out.println("We have " + images.size() + " images");

        for (WebElement image : images) {
            if (isImageBroken(image)) {
                System.out.println("BROKEN IMAGE: " + image.getAttribute("src"));
            } else {
                System.out.println("VALID IMAGE: " + image.getAttribute("src"));
            }
        }

        return this;
    }

    private boolean isImageBroken(WebElement image) {
        try {
            return !image.isDisplayed() || image.getAttribute("naturalWidth").equals("0");//The naturalWidth property in HTML is 0 if an image fails to load.
        } catch (Exception e) {
            System.out.println("Error checking image: " + e.getMessage());
            return true; // Assume the image is broken if an error occurs
        }
    }
}
