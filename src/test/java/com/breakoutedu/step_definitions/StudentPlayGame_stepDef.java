package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import com.breakoutedu.utility.BE_util;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentPlayGame_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    BE_util beUtil = new BE_util();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    @Given("student is on the Home Page")
    public void studentIsOnTheHomePage() {
        beUtil.studentLoginWthBE(read("student1_user"),read("studentPassword"));
    }

    @When("student clicks My Games module and clicks Create a Game")
    public void studentClicksCreateAGame() {
        homePage.myGamesModule.click();
        gamesPage.createGameBtn.click();
    }

    @And("selects class and clicks create game title")
    public void selectsClassAndClicksCreateGameTitle() {
        gamesPage.selectLastClassFromDropdown().click();

    }

    @And("selects {string}")
    public void selects(String gameType) {
        gamesPage.selectGameCategory(gameType).click();
    }

    @And("provides valid game title and clicks next")
    public void providesValidGameTitleAndClicksNext() {
        gamesPage.titleInput.sendKeys(faker.animal().name());
    }

    @And("inputs Lock Story text")
    public void inputsLockStoryText() {
        gamesPage.lockStoryInput.sendKeys(faker.chuckNorris().fact());
    }

    @And("selects Text lock clue")
    public void selectsTextLockClue() {
        gamesPage.textLockClueBtn.click();
    }

    @And("inputs lock clue text")
    public void inputsLockClueText() {
        gamesPage.textLockInput.sendKeys(faker.harryPotter().quote());
    }

    @And("selects lock clue combination")
    public void selectsLockClueCombination() {
        gamesPage.selectLetterForLockClue("TEST");
    }

    @And("clicks Save as draft")
    public void clicksSaveAsDraft() {
        gamesPage.seqGameBtn.click();
    }

    @Then("verifies the game has been created")
    public void verifiesTheGameHasBeenCreated() {
         homePage.myGamesModule.click();

    }
}
