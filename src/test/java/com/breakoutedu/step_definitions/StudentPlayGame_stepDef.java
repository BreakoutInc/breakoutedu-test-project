package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;

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

public class StudentPlayGame_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();



    public String gameTitle = faker.ancient().hero();

    @Given("student is on the Home Page")
    public void studentIsOnTheHomePage() {
        goTo("student");
        loginPage.studentLoginWthBE(read("student1_user"), read("studentPassword"));
    }

    @When("student clicks My Games module")
    public void studentClicksCreateAGame() {
        waitForPageToLoad(5);
        homePage.myGamesModule.click();
    }

    @And("clicks Create a Game")
    public void clicksCreateAGame() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(gamesPage.createNewGameBtn));
        gamesPage.createNewGameBtn.click();
    }

    @And("selects class and clicks create game button")
    public void selectsClassAndClicksCreateGame() {
        gamesPage.listOfClasses.get(0).click();
        gamesPage.createGameBtn.click();

    }

    @And("selects game type")
    public void selects() {
        gamesPage.selectGameCategory("Single lock").click();
    }

    @And("provides valid game title and clicks next")
    public void providesValidGameTitleAndClicksNext() {
        gamesPage.titleInput.sendKeys(gameTitle);
        gamesPage.nextBtn.click();
    }

    @And("inputs Lock Story text")
    public void inputsLockStoryText() {
        gamesPage.lockStoryInputSingleLock.sendKeys(faker.chuckNorris().fact());
    }

    @And("selects Text lock clue")
    public void selectsTextLockClue() {
        scrollToElement(gamesPage.textLockClueBtn);
        clickWithJS(gamesPage.textLockClueBtn);
    }

    @And("inputs lock clue text")
    public void inputsLockClueText() {
        gamesPage.textLockInput.sendKeys(faker.harryPotter().quote());
        waitFor(2);
    }

    @And("selects lock clue combination")
    public void selectsLockClueCombination() {
        gamesPage.selectLetterForLockClue("TEST");
    }

    @And("clicks Save as draft")
    public void clicksSaveAsDraft() {
        scrollToElement(gamesPage.saveAsDraftBtn);
        clickWithJS(gamesPage.saveAsDraftBtn);
    }

    @Then("verifies the game has been created")
    public void verifiesTheGameHasBeenCreated() {
        homePage.myGamesModule.click();
        waitForPageToLoad(5);
        Assert.assertTrue(gamesPage.gameIsPresentInCreatedGamesColumn(gameTitle));

    }

    //--------------MULTILOCK GAME------------------------
    @And("selects {string}")
    public void selects(String gameType) {
        gamesPage.selectGameCategory(gameType).click();
    }


    @And("creates color lock")
    public void createsLock() {
        gamesPage.createLockForMultlGame("color", "text", "RXQB");
    }

    @And("clicks Add Another Lock button")
    public void clicksAddAnotherLockButton() {
        gamesPage.addAnotherLockBtn.click();
    }

    @And("creates directional lock")
    public void createsDirectLock() {
        gamesPage.createLockForMultlGame("directional", "text", "UUDR");
    }

    @And("clicks Add New Lock button")
    public void clicksAddNewLockButton() {
        clickWithJS(gamesPage.addNewLock);
    }


    @And("inputs Lock Story text for multi-lock")
    public void inputsLockStoryTextForMultiLock() {
        gamesPage.lockStoryInputMultiL.sendKeys(faker.chuckNorris().fact());
    }

}


