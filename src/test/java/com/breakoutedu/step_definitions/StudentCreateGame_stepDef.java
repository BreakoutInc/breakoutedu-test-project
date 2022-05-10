package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.*;

import static com.breakoutedu.utility.ConfigReader.*;

import static com.breakoutedu.utility.BrowserUtil.*;

import com.breakoutedu.utility.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentCreateGame_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();
    StudentPlayGamePage playGamePage = new StudentPlayGamePage();
    StudentCreatesGamePage createGamesPage = new StudentCreatesGamePage();



    public String gameTitle = faker.ancient().hero();

    @Given("student is on the Home Page")
    public void studentIsOnTheHomePage() {
        goTo("student");
        loginPage.studentLoginWthBE(read("student2"), read("stud.psw"));
    }

    @When("student clicks My Games module")
    public void studentClicksCreateAGame() {
        waitForPageToLoad(5);
    //    homePage.myGamesModule.click();
        clickWithJS(homePage.myGamesModule);
    }

    @And("clicks Create a Game")
    public void clicksCreateAGame() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(gamesPage.createNewGameBtn));
        gamesPage.createNewGameBtn.click();
    }

    @And("selects class and clicks create game button")
    public void selectsClassAndClicksCreateGame() {
        waitForClickability(createGamesPage.listOfClasses.get(0),5);
        createGamesPage.listOfClasses.get(0).click();
        createGamesPage.createGameBtn.click();

    }

    @And("selects game type")
    public void selects() {
        createGamesPage.selectGameCategory("Single lock").click();
    }

    @And("provides valid game title and clicks next")
    public void providesValidGameTitleAndClicksNext() {
        createGamesPage.titleInput.sendKeys(gameTitle);
        createGamesPage.nextBtn.click();
    }

    @And("inputs Lock Story text")
    public void inputsLockStoryText() {
        createGamesPage.lockStoryInputSingleLock.sendKeys(faker.chuckNorris().fact());
    }

    @And("selects Text lock clue")
    public void selectsTextLockClue() {
        scrollToElement(createGamesPage.textLockClueBtn);
        clickWithJS(createGamesPage.textLockClueBtn);
    }

    @And("inputs lock clue text")
    public void inputsLockClueText() {
        createGamesPage.textLockInput.sendKeys(faker.harryPotter().quote());
        waitFor(2);
    }

    @And("selects lock clue combination")
    public void selectsLockClueCombination() {
        createGamesPage.selectLetterForLockClue("TEST");
    }

    @And("clicks Save as draft")
    public void clicksSaveAsDraft() {
        scrollToElement(createGamesPage.saveAsDraftBtn);
        clickWithJS(createGamesPage.saveAsDraftBtn);
    }

    @Then("verifies the game has been created")
    public void verifiesTheGameHasBeenCreated() {
        homePage.myGamesModule.click();
        waitForPageToLoad(5);
        Assert.assertTrue(createGamesPage.gameIsPresentInCreatedGamesColumn(gameTitle));

    }

    //--------------MULTILOCK GAME------------------------
    @And("selects {string}")
    public void selects(String gameType) {
        createGamesPage.selectGameCategory(gameType).click();
    }


    @And("creates color lock")
    public void createsLock() {
        createGamesPage.createLockForMultlGame("color", "text", "RXQB");
    }

    @And("clicks Add Another Lock button")
    public void clicksAddAnotherLockButton() {
        createGamesPage.addAnotherLockBtn.click();
    }

    @And("creates directional lock")
    public void createsDirectLock() {
        createGamesPage.createLockForMultlGame("directional", "text", "UUDR");
    }

    @And("clicks Add New Lock button")
    public void clicksAddNewLockButton() {
        clickWithJS(createGamesPage.addNewLock);
    }


    @And("inputs Lock Story text for multi-lock")
    public void inputsLockStoryTextForMultiLock() {
        createGamesPage.lockStoryInputMultiL.sendKeys(faker.chuckNorris().fact());
    }

    @And("enables auto save")
    public void enablesAutoSave() {

    }

    @And("clicks on a created game with auto save enabled")
    public void clicksOnACreatedGameWithAutoSaveEnabled() {
    }

    @Then("verifies game was autosaved successfully")
    public void verifiesGameWasAutosavedSuccessfully() {
    }
}


