package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.StudentSignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class StudentSignup_stepDef {
    StudentSignUpPage signUpPage = new StudentSignUpPage();


    //----
    String classCode = "";

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
        signUpPage.classCodeInput.sendKeys();
    }

    @And("provides valid username")
    public void providesValidUsername() {
    }

    @And("creates a password and clicks Next")
    public void createsAPasswordAndClicksNext() {
    }

    @Then("verifies account was created")
    public void verifiesAccountWasCreated() {
    }

    @And("provides invalid username")
    public void providesInvalidUsername() {
    }

    @Then("verifies Username must be between {int} and {int} characters message is displayed")
    public void verifiesUsernameMustBeBetweenAndCharactersMessageIsDisplayed(int arg0, int arg1) {
    }

    @And("provides not matched password")
    public void providesNotMatchedPassword() {
    }

    @Then("verifies Password are not matched alert is displayed")
    public void verifiesPasswordAreNotMatchedAlertIsDisplayed() {
    }
}
