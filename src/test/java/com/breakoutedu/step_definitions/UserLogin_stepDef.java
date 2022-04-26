package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.TeacherHomePage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;

public class UserLogin_stepDef {
    BELoginPage loginPage = new BELoginPage();
    TeacherHomePage userHomePage = new TeacherHomePage();
    Faker faker = new Faker();


    @Given("user is on Login Page")
    public void userIsOnLoginPage() {
        goTo("user");
        waitForPageToLoad(4);

    }

    @When("user provides valid {string} and {string}")
    public void userProvidesValidAnd(String email, String password) {
        loginPage.teacherEmailInput.sendKeys(email);
        loginPage.teacherPwdInput.sendKeys(password);
    }

    @And("clicks Sign In button")
    public void clicksSignInButton() {
        loginPage.teachSignInBtn.click();
    }

    @Then("verifies logged in successfully")
    public void verifiesLoggedInSuccessfully() {
        waitForPageToLoad(4);
        assertTrue(userHomePage.myAccountIcon.isDisplayed());
    }

    @When("user provides invalid email and password")
    public void userProvidesInvalidEmailAndPassword() {
        loginPage.teacherEmailInput.sendKeys("duke@gmail.com");
        loginPage.teacherPwdInput.sendKeys(faker.letterify("######"));
        loginPage.teachSignInBtn.click();
    }

    @Then("verifies Invalid credentials window is displayed")
    public void verifiesInvalidCredentialsWindowIsDisplayed() {
        waitForPageToLoad(3);
       assertTrue(loginPage.teacherErrorMsg.isDisplayed());

    }
}
