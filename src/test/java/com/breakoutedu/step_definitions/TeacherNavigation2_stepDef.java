package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.teacher.TeacherGameSearchDetailsPage;
import com.breakoutedu.pages.teacher.TeacherHomePage;
import com.breakoutedu.pages.teacher.TeacherMyGamesPage;
import static com.breakoutedu.utility.ConfigReader.*;

import com.breakoutedu.utility.BrowserUtil;
import static com.breakoutedu.utility.Driver.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class TeacherNavigation2_stepDef {
    TeacherMyGamesPage myGamesPage = new TeacherMyGamesPage();
    TeacherHomePage homePage = new TeacherHomePage();
    TeacherGameSearchDetailsPage gameSearchDetailsPage = new TeacherGameSearchDetailsPage();

    @And("clicks Details button")
    public void clicksDetailsButton() {
      myGamesPage.gameDetailsBtn.click();
    }

    @Then("verifies the Game Details page is displayed")
    public void verifiesTheGameDetailsPageIsDisplayed() {
        assertTrue(myGamesPage.numberOfLocksTextTitle.isDisplayed());
    }

    @When("teacher clicks on recommended game image")
    public void teacherClicksOnRecommendedGameImage() {
        homePage.recommendedGameImage.click();
    }

    @Then("verifies Game Search Details page is displayed")
    public void verifiesGameSearchDetailsPageIsDisplayed() {
        assertTrue(gameSearchDetailsPage.assignGameBtn.isDisplayed());
    }

    @When("teacher clicks on Help button")
    public void teacherClicksOnHelpButton() {
        assertTrue(getDriver().getWindowHandles().size() == 1);
       BrowserUtil.clickWithJS(homePage.helpModule);
       BrowserUtil.waitFor(6);
    }

    @Then("Help Desk is displayed")
    public void helpDeskIsDisplayed() {
        String originalWindow = getDriver().getWindowHandle();
        BrowserUtil.switchToWindow("BreakoutEDU Help Center");
        assertTrue(getDriver().getCurrentUrl().equalsIgnoreCase(read("help.page.url")));

        }

    }

