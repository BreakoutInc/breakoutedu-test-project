package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentCreatesGamePage;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import com.breakoutedu.utility.ConfigReader;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;


public class StudentCreateGameDetails_stepDef {
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();
    StudentCreatesGamePage createsGamePage = new StudentCreatesGamePage();


    @Then("verifies all {string} can be selected")
    public void verifiesAllCanBeSelected(String lockTypes) {
        waitForPageToLoad(5);
           clickWithJS(createsGamePage.selectLockTypeForMultilockGame(lockTypes));
            waitFor(1);
            assertTrue(createsGamePage.selectLockTypeForMultilockGame(lockTypes).getAttribute("class").equalsIgnoreCase("select-lock active"));
    }


    @And("provides title under three characters and clicks next")
    public void providesTitleUnderCharacters() {
        createsGamePage.titleInput.sendKeys(faker.letterify("##"));
        createsGamePage.nextBtn.click();
    }

    @Then("verifies The title must be at least 3 characters alert is displayed")
    public void verifiesAlertIsDisplayed() {
        assertTrue(createsGamePage.alertForWrongTitle.isDisplayed());
    }


    @And("provides existing game title and clicks next")
    public void providesExistingGameTitleAndClicksNext() {
        createsGamePage.titleInput.sendKeys(ConfigReader.read("existing.game.title"));
        createsGamePage.nextBtn.click();
    }

    @Then("verifies Title already has been taken alert is displayed")
    public void verifiesTitleAlreadyHasBeenTakenAlertIsDisplayed() {
        createsGamePage.alertForWrongTitle.isDisplayed();
    }

    @And("selects Non-Sequential game type")
    public void selectsNonSequentialGameType() {
        createsGamePage.selectGameCategory("Non-sequential game").click();
    }

    @And("clicks Save and Play")
    public void clicksSaveAndPlay() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.elementToBeClickable(gamesPage.saveAndPlayBtn));
        clickWithJS( createsGamePage.saveAndPlayBtn );
    }

    @Then("verifies Please provide lock clue text alert is displayed")
    public void verifiesPleaseProvideLockClueTextAlertIsDisplayed() {
        assertTrue(createsGamePage.alertForNoLockClueText.isDisplayed());
    }

}
