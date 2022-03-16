package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentMyGamesPage;
import static com.breakoutedu.utility.ConfigReader.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;

public class StudentUploadImage_stepDef {
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    @And("selects Image lock type")
    public void selectsImageLockType() {
        gamesPage.selectLockClue("Image");
    }

    @And("uploads image")
    public void uploadsImage() {
        gamesPage.uploadFile.sendKeys(read("image_path"));
    }

    @Then("verifies image was uploaded")
    public void verifiesImageWasUploaded() {
        waitForPageToLoad(3);
        System.out.println(" This is an attrib value   ->"+gamesPage.uploadImgAssert.getAttribute("src"));
        assertFalse(gamesPage.uploadImgAssert.getAttribute("src").contains("front/images/upload-icon.png"));

    }

    @And("uploads image with invalid media type")
    public void uploadsImageWithInvalidMediaType() {
        gamesPage.uploadFile.sendKeys(read("imageWrongType_path"));
    }

    @Then("verifies error message is displayed")
    public void verifiesErrorMessageIsDisplayed() {
        assertTrue(gamesPage.unsupportedMediaTypeErrorMsg.isDisplayed());
    }

    @And("uploads large image as a lock clue")
    public void uploadsLargeImageAsALockClue() {
        gamesPage.uploadFile.sendKeys(read("imageLarge_path"));
    }

    @Then("verifies the please insert less than or equal to five mb alert is displayed")
    public void verifiesImageTooLargeAlertIsDisplayed() {
       assertTrue(gamesPage.imageTooLargeErrorMsg.isDisplayed());
    }

    @And("creates lock with custom image type - large")
    public void createsLockWithCustomImageType() {
        gamesPage.createLockForMultlGame("directional", "text", "UDLR","imageWrongType_path");
    }

    @And("creates lock with custom image type - wrong media type")
    public void createsLockWithCustomImageTypeWrongMediaType() {
        gamesPage.createLockForMultlGame("directional", "text", "UDLR","imageLarge_path");
    }
}
