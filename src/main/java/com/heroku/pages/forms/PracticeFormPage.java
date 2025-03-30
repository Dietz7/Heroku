package com.heroku.pages.forms;

import com.heroku.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    public PracticeFormPage uploadFile(String path) {
        fileUpload.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    public PracticeFormPage clickUploadButton() {
        click(fileSubmit);
        return this;
    }

    @FindBy(id = "drag-drop-upload")
    WebElement dragDropUpload;


    /*public PracticeFormPage dragAndDropFile(String path) {
        File file = new File(path);
        new Actions(driver).moveToElement(dragDropUpload).click().sendKeys(path).build().perform();
        return this;
    }*/

    @FindBy(id = "uploaded-files")
    WebElement uploadedFiles;

    public PracticeFormPage verifyFileUploaded(String expFileName) {
        String actualFileName = uploadedFiles.getText().trim();
        Assertions.assertEquals(expFileName, actualFileName);
        return this;
    }

    @FindBy(id = "drag-drop-upload")
    private WebElement uploadArea;

    public PracticeFormPage verifyDragDropAreaDisplayed() {
        Assertions.assertTrue(uploadArea.isDisplayed());
        return this;
    }
}
