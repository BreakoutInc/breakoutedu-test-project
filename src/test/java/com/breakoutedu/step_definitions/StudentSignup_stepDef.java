package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.student.StudentHomePage;
import com.breakoutedu.pages.student.StudentSignUpPage;
import static com.breakoutedu.utility.ConfigReader.*;

import com.breakoutedu.utility.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.*;
import static com.breakoutedu.utility.BrowserUtil.*;

public class StudentSignup_stepDef {
    StudentSignUpPage signUpPage = new StudentSignUpPage();
    StudentHomePage homePage = new StudentHomePage();


    //----
    Faker faker = new Faker();

    @Given("student is on the Sign Up Page")
    public void studentIsOnTheSignUpPage() {
        goTo("student");
    }

    @And("clicks on signup here")
    public void clicksOnSignupHere() {
        signUpPage.signUphere.click();
    }

    @And("clicks on Signup With Breakout EDU")
    public void clicksOnSignupWithBreakoutEDU() {
        signUpPage.signupWithBE.click();
    }

    @And("types class code and clicks Next")
    public void typesClassCodeAndClicksNext() {
        signUpPage.classCodeInput.sendKeys(read("class.code"));
        signUpPage.nextBtn_step1.click();
    }


    @And("fills up personal info and clicks next")
    public void fillsUpPersonalInfoAndClicksNext() {
        signUpPage.firstNameInput.sendKeys(faker.name().firstName());
        signUpPage.lastNameInput.sendKeys(faker.letterify("#"));
        signUpPage.usernameInput.sendKeys(faker.name().username());
        signUpPage.nextBtn_step2.click();

    }

    @And("provides password and psw confirmation and next")
    public void providesPasswordAndPswConfirmationAndNext() {
       // waitForClickability(signUpPage.passwordInput,10);
        signUpPage.passwordInput.sendKeys(read("stud.psw"));
        signUpPage.passwordConfirmationInput.sendKeys(read("stud.psw"));
        signUpPage.nextBtn_step3.click();
    }

    @And("clicks Create account button")
    public void clicksCreateAccountButton() {
        signUpPage.createAccountBtn.click();
    }


    @Then("verifies Student Home Page in displayed")
    public void verifiesAccountWasCreated() {
        waitForPageToLoad(5);
       assertTrue(homePage.homeModule.isDisplayed());
    }

    @And("provides invalid username and clicks next")
    public void providesInvalidUsername() {
        signUpPage.firstNameInput.sendKeys(faker.name().firstName());  //need to provide first and last name to display error msg correctly
        signUpPage.lastNameInput.sendKeys(faker.letterify("#"));
        signUpPage.usernameInput.sendKeys(faker.letterify("####"));
        signUpPage.nextBtn_step2.click();
    }

    @Then("verifies Username must be between six and ten characters message is displayed")
    public void verifiesUsernameMustBeBetweenSixAndTenCharactersMessageIsDisplayed() {
        assertTrue(signUpPage.invalidUsernameMsg.isDisplayed());
    }


    @And("provides not matched password")
    public void providesNotMatchedPassword() {
        signUpPage.passwordInput.sendKeys(faker.animal().name());
        signUpPage.passwordConfirmationInput.sendKeys(faker.color().name());
        signUpPage.nextBtn_step3.click();
    }

    @Then("verifies Password are not matched alert is displayed")
    public void verifiesPasswordAreNotMatchedAlertIsDisplayed() {
        String alertText = Driver.getDriver().switchTo().alert().getText();
        assertEquals("Password are not matched", alertText);

    }

    @And("provides invalid class code")
    public void providesInvalidClassCode() {
        signUpPage.classCodeInput.sendKeys(faker.letterify("##"));
        signUpPage.nextBtn_step1.click();
    }

    @Then("verifies This class code is invalid message is displayed")
    public void verifiesThisClassCodeIsInvalidMessageIsDisplayed() {
        waitFor(2);
        assertTrue(signUpPage.invalidClassCodeMsg.isDisplayed());
    }

}
