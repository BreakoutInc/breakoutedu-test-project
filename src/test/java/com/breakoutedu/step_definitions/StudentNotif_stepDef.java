package com.breakoutedu.step_definitions;

import static com.breakoutedu.utility.BrowserUtil.*;

import com.breakoutedu.pages.student.StudentGameDetailPage;
import com.breakoutedu.pages.student.StudentHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class StudentNotif_stepDef {
StudentHomePage homePage = new StudentHomePage();
StudentGameDetailPage gameDetailPage = new StudentGameDetailPage();



    @And("scrolls notifications down")
    public void scrollsNotificationsDown() {
    }

    @Then("verifies the notifications was scrolled down")
    public void verifiesTheNotificationsWasScrolledDown() {

    }

    @Given("teacher assigned game to a class")
    public void teacherAssignedGameToAClass() {
    }

    @Then("verifies new notifications is displayed")
    public void verifiesNewNotificationsIsDisplayed() {
    }

    @And("click on close notifications icon")
    public void clickOnCloseNotificationsIcon() {
        System.out.println(homePage.notificationTitle.isDisplayed());
        homePage.closeNotificatonsIcon.click();
    }

    @Then("verifies notifications was closed")
    public void verifiesNotificationsWasClosed() {

        assertTrue( isNotDisplayed(homePage.notificationTitle) );
    }

    @And("clicks on notification about game revision")
    public void clicksOnNotificationAboutGameRevision() {
        homePage.notificationToReviseGame.click();
    }

    @Then("verifies the Game Details page for that game is opened")
    public void verifiesTheGameDetailsPageForThatGameIsOpened() {
        waitForPageToLoad(3);
     assertTrue(gameDetailPage.gameDetailsTitle.isDisplayed());
    }
}
