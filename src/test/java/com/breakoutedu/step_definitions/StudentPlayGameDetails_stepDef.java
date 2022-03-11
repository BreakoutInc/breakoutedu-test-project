package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.breakoutedu.utility.BrowserUtil.waitForPageToLoad;
import static org.junit.Assert.*;
import java.util.List;
import static com.breakoutedu.utility.BrowserUtil.waitFor;

public class StudentPlayGameDetails_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    @Then("verifies all {string} can be selected")
    public void verifiesAllCanBeSelected(List<String> lockTypes) {
        for (String eachType : lockTypes) {
            gamesPage.selectLockTypeForMultilockGame(eachType).click();
            waitFor(1);
            assertTrue(gamesPage.selectLockTypeForMultilockGame(eachType).getAttribute("class").equalsIgnoreCase("select-lock active"));
        }
    }


    @And("provides title under three characters")
    public void providesTitleUnderCharacters() {
        gamesPage.titleInput.sendKeys(faker.letterify("##"));
    }

    @Then("verifies The title must be at least 3 characters alert is displayed")
    public void verifiesAlertIsDisplayed() {
        assertTrue(gamesPage.alertForWrongTitle.isDisplayed());
    }

    @And("provides existing game title and clicks next")
    public void providesExistingGameTitleAndClicksNext() {
        homePage.myGamesModule.click();
        waitForPageToLoad(5);
        Assert.assertTrue(gamesPage.gameIsPresentInCreatedGamesColumn(""));
        gamesPage.titleInput.sendKeys("test");
    }

    @Then("verifies Title already has been taken alert is displayed")
    public void verifiesTitleAlreadyHasBeenTakenAlertIsDisplayed() {

    }
}
