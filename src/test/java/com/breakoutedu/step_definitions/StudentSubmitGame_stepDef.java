package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class StudentSubmitGame_stepDef {

    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    //----
    int initAmountOfGames = gamesPage.submittedGamesList.size();

    @And("clicks on Submit to Class button")
    public void clicksOnSubmitToClassButton() {
        gamesPage.submitToClassBtn.click();

    }

    @And("adds comment in popped up window")
    public void addsCommentInPoppedUpWindow() {
      gamesPage.submitGameInput.sendKeys(faker.howIMetYourMother().quote());
    }

    @And("clicks Submit button")
    public void clicksSubmitButton() {
        gamesPage.submitBtn.click();
    }

    @Then("verifies the game was submitted")
    public void verifiesTheGameWasSubmitted() {
        int newAmountOfGames = gamesPage.submittedGamesList.size();
        assertEquals(initAmountOfGames + 1, newAmountOfGames);
    }

    @Then("verifies message Error : Field is required is displayed")
    public void verifiesMessageErrorFieldIsRequiredIsDisplayed() {
       assertTrue( gamesPage.submitWthNoCommentError.isDisplayed() );
    }
}
