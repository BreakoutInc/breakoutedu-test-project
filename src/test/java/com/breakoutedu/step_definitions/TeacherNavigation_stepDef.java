package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;

import com.breakoutedu.pages.teacher.*;

import static com.breakoutedu.utility.BrowserUtil.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class TeacherNavigation_stepDef {
    BELoginPage beLoginPage = new BELoginPage();
    TeacherHomePage homePage = new TeacherHomePage();
    TeacherMyAccountPage myAccountPage = new TeacherMyAccountPage();
    TeacherMyClassesPage myClassesPage = new TeacherMyClassesPage();
    TeacherMyGamesPage myGamesPage = new TeacherMyGamesPage();
    TeacherShopPage shopPage = new TeacherShopPage();

    @Given("Teacher is on the Home Page")
    public void teacherIsOnTheHomePage() {
        goTo("user");
       beLoginPage.teacherLogin(read("teacher1"), read("teacher.psw"));
    }

    @When("teacher clicks on the avatar icon")
    public void teacherClicksOnTheAvatarIcon() {
        homePage.myAccountIcon.click();
    }

    @Then("My Account page is displayed")
    public void myAccountPageIsDisplayed() {
        assertTrue(myAccountPage.pageTitleBubble.isDisplayed());
        assertTrue(myAccountPage.changePswdBtn.isDisplayed());
    }

    @When("teacher clicks on the My Account button")
    public void teacherClicksOnTheMyAccountButton() {
        clickWithJS(homePage.myAccountBtn);
    }

    @When("teacher clicks on My Classes")
    public void teacherClicksOnMyClasses() {
        homePage.myClassesModule.click();
    }

    @Then("My Classes page is displayed")
    public void myClassesPageIsDisplayed() {
        assertTrue(myClassesPage.createClassBtn.isDisplayed());
    }

    @When("teacher clicks on My Games")
    public void teacherClicksOnMyGames() {
        homePage.myGamesModule.click();
    }

    @Then("My Games page is displayed")
    public void myGamesPageIsDisplayed() {
        assertTrue(myGamesPage.createGameBtn.isDisplayed());
    }

    @When("teacher clicks on Shop")
    public void teacherClicksOnShop() {
        homePage.shopModule.click();
    }

    @Then("Shop page is displayed")
    public void shopPageIsDisplayed() {
        assertTrue(shopPage.pageHeaderBubble.isDisplayed());
    }

    @When("teacher clicks on My Classes from the Home page")
    public void teacherClicksOnMyClassesFromTheHomePage() {
        homePage.viewAllClassesBtn.click();
    }

    @When("teacher clicks on My Games from the Home Page")
    public void teacherClicksOnMyGamesFromTheHomePage() {
        homePage.viewAllGamesBtn.click();
    }
}
