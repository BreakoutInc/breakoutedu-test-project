package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentCreatesGamePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import static com.breakoutedu.utility.ConfigReader.*;

import com.breakoutedu.pages.StudentPlayGamePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;

public class StudentUploadImage_stepDef {
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();
    StudentPlayGamePage playGamePage = new StudentPlayGamePage();
    StudentCreatesGamePage createsGamePage = new StudentCreatesGamePage();

    @And("selects Image lock type")
    public void selectsImageLockType() {
        createsGamePage.selectLockClue("Image");
    }

    @And("uploads image")
    public void uploadsImage() {
        createsGamePage.uploadFile.sendKeys(read("image.path"));
    }

    @Then("verifies image was uploaded")
    public void verifiesImageWasUploaded() {
        waitForPageToLoad(3);
        System.out.println(" This is an attrib value   ->" + createsGamePage.uploadImgAssert.getAttribute("src"));
        assertFalse(createsGamePage.uploadImgAssert.getAttribute("src").contains("front/images/upload-icon.png"));

    }

    @And("uploads image with invalid media type")
    public void uploadsImageWithInvalidMediaType() {
        createsGamePage.uploadFile.sendKeys(read("image.wrong.type.path"));
    }

    @Then("verifies error message is displayed")
    public void verifiesErrorMessageIsDisplayed() {
        assertTrue(createsGamePage.unsupportedMediaTypeErrorMsg.isDisplayed());
    }


    @Then("verifies the please insert less than or equal to five mb alert is displayed")
    public void verifiesImageTooLargeAlertIsDisplayed() {
        assertTrue(createsGamePage.imageTooLargeErrorMsg.isDisplayed());
    }

    @And("creates lock with image clue")
    public void createsLockWithImageTypeClue () {
        createsGamePage.createLockForMultlGame("directional", "text", "UDLR", "image.path");
    }

    @And("creates lock with custom image type - large")
    public void createsLockWithCustomImageType() {
        createsGamePage.createLockForMultlGame("directional", "text", "UDLR", "image.large.path");
    }

    @And("creates lock with custom image type - wrong media type")
    public void createsLockWithCustomImageTypeWrongMediaType () {
        createsGamePage.createLockForMultlGame("directional", "text", "UDLR", "image.wrong.type.path");
        }


    @And("uploads large image as a lock clue")
    public void uploadsLargeImageAsALockClue() {
        createsGamePage.uploadFile.sendKeys(read("image.large.path"));
    }
}

