package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentPlayGamePage;
import com.breakoutedu.pages.TeacherLOTDPage;
import static com.breakoutedu.utility.BrowserUtil.*;

import static com.breakoutedu.utility.Driver.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.breakoutedu.utility.ConfigReader.read;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class StudentPlayGame_stepDef {
    StudentHomePage homePage = new StudentHomePage();
    StudentPlayGamePage playGamePage = new StudentPlayGamePage();
     TeacherLOTDPage teacherLOTDPage = new TeacherLOTDPage();
    BELoginPage loginPage = new BELoginPage();



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

    @And("clicks on a game name")
    public void clicksOnAGameName() {
    }


    //----?????

    @And("clicks on a lock")
    public void clicksOnALock() {
     clickWithJS( playGamePage.locksList.get(0) );
    }

    @And("clicks on Combination Bar")
    public void clicksOnCombinationBar() {
    }

    @And("enters valid combination")
    public void entersValidCombination() {
    }

}
