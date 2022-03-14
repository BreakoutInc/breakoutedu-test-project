package com.breakoutedu.step_definitions;
import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;

public class StudentUploadImage_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    @And("selects Image lock type")
    public void selectsImageLockType() {
        gamesPage.selectLockClue("Image");
    }

    @And("uploads image")
    public void uploadsImage() {
        gamesPage.uploadFile.sendKeys(read("image_FilePath"));
    }

    @Then("verifies image was uploaded")
    public void verifiesImageWasUploaded() {
        assertFalse(gamesPage.uploadImgAssert.getAttribute("src").contains("front/images/upload-icon.png"));

    }

    @And("uploads image with invalid media type")
    public void uploadsImageWithInvalidMediaType() {
        gamesPage.uploadFile.sendKeys("/Users/yuliiarublenko/Downloads/IMG_8236.HEIC");
    }

    @Then("verifies error message is displayed")
    public void verifiesErrorMessageIsDisplayed() {
        assertTrue(gamesPage.unsupportedMediaTypeErrorMsg.isDisplayed());
    }

    @And("uploads large image as a lock clue")
    public void uploadsLargeImageAsALockClue() {
        gamesPage.uploadFile.sendKeys(read("largeImage_path"));
    }

    @Then("verifies the please insert less than or equal to five mb alert is displayed")
    public void verifiesThePleaseInsertLessThanOrEqualToMbAlertIsDisplayed() {
       assertTrue(gamesPage.imageTooLargeErrorMsg.isDisplayed());
    }
}
