package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentPlayGamePage;
import com.breakoutedu.pages.TeacherLOTDPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class StudentPlayGame_stepDef {
    StudentHomePage homePage = new StudentHomePage();
    StudentPlayGamePage playGamePage = new StudentPlayGamePage();
     TeacherLOTDPage teacherLOTDPage = new TeacherLOTDPage();



    @Given("teacher has a class")
    public void teacherHasAClass() {
    }

    @When("student clicks LOTD game banner")
    public void studentClicksLOTDGameBanner() {
     homePage.lotdPlayBanner.click();
    }

    @And("plays game")
    public void playsGame() {
        Iterator<WebElement> it = playGamePage.locksList.iterator();
        while(it.hasNext()){
            it.next().click();
            playGamePage.keyboardImg.click();
            playGamePage.enterGameClueCombination(teacherLOTDPage.lotdAnswerKey.getText());  // modify to match one lock and multi lock games
        }
    }


    @Then("verifies Congratulation! message is displayed")
    public void verifiesCongratulationMessageIsDisplayed() {
    }

    @And("clicks on a game name")
    public void clicksOnAGameName() {
    }


    //----?????

    @And("clicks on a lock")
    public void clicksOnALock() {

    }

    @And("clicks on Combination Bar")
    public void clicksOnCombinationBar() {
    }

    @And("enters valid combination")
    public void entersValidCombination() {
    }

}
