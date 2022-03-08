package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import static com.breakoutedu.utility.BrowserUtil.*;

import com.breakoutedu.utility.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;


public class StudentLoginBE_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();



    @Given("student is on the Student Login Page")
    public void studentIsOnTheStudentLoginPage() {
        goTo("student");
    }

    @When("student clicks on Log In with Breakout EDU")
    public void studentClicksOnLogInWithBreakoutEDU() {
        loginPage.logInWithBE_Btn.click();
    }

    @And("enters valid Email and Password")
    public void entersValidEmailAndPassword() {
        loginPage.studentUsernameInput.sendKeys(read("student2_user"));
        loginPage.studentPswInput.sendKeys(read("studentPassword"));
    }

    @And("clicks on Log In")
    public void clicksOnLogIn() {
        loginPage.studentLogInBtn.click();
    }

    @Then("verifies Student Home Page in displayed")
    public void verifiesStudentHomePageInDisplayed() {
        waitForPageToLoad(4);
        assertEquals("Breakout EDU |", Driver.getDriver().getTitle());
    }

    @And("enters invalid email and password")
    public void entersInvalidEmailAndPassword() {
        loginPage.studentUsernameInput.sendKeys(faker.funnyName().name());
        loginPage.studentPswInput.sendKeys(faker.letterify("############"));
    }

    @Then("verifies Username or password is invalid message is displayed")
    public void verifiesUsernameOrPasswordIsInvalidMessageIsDisplayed() {
        waitForPageToLoad(4);
        assertTrue(loginPage.errorMsg.isDisplayed());
    }


}
