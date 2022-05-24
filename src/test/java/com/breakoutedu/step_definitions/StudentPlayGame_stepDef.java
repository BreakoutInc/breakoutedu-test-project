package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.*;

import static com.breakoutedu.utility.BrowserUtil.*;

import static com.breakoutedu.utility.Driver.*;

import com.breakoutedu.pages.student.StudentHomePage;
import com.breakoutedu.pages.student.StudentMyGamesPage;
import com.breakoutedu.pages.student.StudentPlayGamePage;
import com.breakoutedu.pages.teacher.TeacherLOTDPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.breakoutedu.utility.ConfigReader.read;
import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class StudentPlayGame_stepDef {
    StudentHomePage homePage = new StudentHomePage();
    StudentPlayGamePage playGamePage = new StudentPlayGamePage();
    TeacherLOTDPage teacherLOTDPage = new TeacherLOTDPage();
    BELoginPage loginPage = new BELoginPage();
    StudentMyGamesPage myGamesPage = new StudentMyGamesPage();

    //--------OPEN GAME TESTS ------------------

    @And("clicks on a game name")
    public void clicksOnAGameName() {
        myGamesPage.gameTitleAsset.get(0).click();  //clicking on the 1st game from list of created
    }

    @Then("verifies game was opened")
    public void verifiesGameWasOpened() {
        assertTrue(playGamePage.elmWrapperOfOpenedGameScreen.isDisplayed());
        assertTrue(playGamePage.closeGameIcon.isDisplayed());
    }

    @When("student clicks on game asset from the New Assignments")
    public void studentClicksOnGameAssetFromTheNewAssignments() {
        homePage.gameNewAssignment.click();
    }

    @When("student clicks Notifications")
    public void studentClicksNotifications() {
        homePage.notificationsModule.click();
    }

    @And("selects a notification about assigned game")
    public void selectsANotificationAboutAssignedGame() {
       clickWithJS( homePage.notificAssignedGame );
    }



    //----------PLAY GAME TESTS ---------------------

    @And("clicks on Combination Bar")
    public void clicksOnCombinationBar() {
    }

    @And("enters valid combination")
    public void entersValidCombination() {
    }


    @And("clicks on a lock")
    public void clicksOnALock() {
        clickWithJS( playGamePage.locksList.get(0) );
    }


    @When("student clicks LOTD game banner")
    public void studentClicksLOTDGameBanner() {
        homePage.lotdPlayBanner.click();
    }

    @And("plays game")
    public void playsGame() {
        //login as a teacher and get an answer key for the LOTD

        getDriver2().navigate().to(read("user.url"));
        loginPage.teacherLogin(read("teacher1"), read("teacher.psw"));
        teacherLOTDPage.lotdGameBanner.click();
        waitForPageToLoad(5);
        teacherLOTDPage.lockCombinationsBtn.click();
        String lotdAnswer = teacherLOTDPage.lotdAnswerKey.getText();




        Iterator<WebElement> it = playGamePage.locksList.iterator();
        while(it.hasNext()){
            it.next().click();
            playGamePage.keyboardImg.click();

            playGamePage.enterGameClueCombination(teacherLOTDPage.getLOTDanswerKey());  // modify to match one lock and multi lock games
        }
    }


    @Then("verifies Congratulation! message is displayed")
    public void verifiesCongratulationMessageIsDisplayed() {
        assertTrue(playGamePage.imageYouBrokeOut.isDisplayed());
    }
}
