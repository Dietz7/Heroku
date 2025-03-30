package com.heroku.tests.forms;

import com.heroku.pages.HomePage;
import com.heroku.pages.forms.PracticeFormPage;
import com.heroku.tests.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PracticeFormTests extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).navigateToFileUpload();

    }

    @Test
    public void uploadFileTest() {
        new PracticeFormPage(driver).uploadFile("C:/tools/1.jpg")
                .clickUploadButton()
                .verifyFileUploaded("1.jpg");
    }

    @Test
    public void testDragDropAreaDisplayed() {
        new PracticeFormPage(driver).verifyDragDropAreaDisplayed();
    }

    @ParameterizedTest
    @MethodSource("filePathsAndNames")
    public void uploadFileTest(String path, String expFileName){
        new PracticeFormPage(driver).uploadFile(path)
                .clickUploadButton()
                .verifyFileUploaded(expFileName);
    }

    public static Stream<Arguments> filePathsAndNames() {
        return Stream.of(
                Arguments.of("C:/tools/1.jpg", "1.jpg"),
                Arguments.of("C:/tools/2.jpg", "2.jpg"),
                Arguments.of("C:/tools/3.jpg", "3.jpg")
        );
    }

  @ParameterizedTest
  @CsvFileSource(resources = "/fileData.csv")
    public void uploadFileTestWithCsvFile(String path, String expFileName){
        new PracticeFormPage(driver).uploadFile(path)
                .clickUploadButton()
                .verifyFileUploaded(expFileName);
  }

}
