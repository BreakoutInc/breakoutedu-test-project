package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import static com.breakoutedu.utility.BrowserUtil.*;

import static com.breakoutedu.utility.Driver.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

import static org.junit.Assert.*;


public class StudentLogin_stepDef {
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
        loginPage.studentUsernameInput.sendKeys(read("student2"));
        loginPage.studentPswInput.sendKeys(read("stud.psw"));
    }

    @And("clicks on Log In")
    public void clicksOnLogIn() {
        loginPage.studentLogInBtn.click();
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


    @When("student clicks on Log In With Google Classroom")
    public void studentClicksOnLogInWithGoogleClassroom() {
     loginPage.loginWithGoogleClass_Btn.click();
    }

    @And("clicks on Use Another Account")
    public void clicksOnUseAnotherAccount() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.elementToBeClickable(loginPage.useAnotherAcc_Btn));
        loginPage.useAnotherAcc_Btn.click();
    }

    @And("enters valid Classroom Email and clicks Next")
    public void entersValidClassroomEmailAndClicksNext() {
        waitForPageToLoad(3);
        String mainWindow = getDriver().getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();

        for (String ChildWindow : allWindowHandles) {
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                getDriver().switchTo().window(ChildWindow);
                loginPage.emailGoogleClass_Input.sendKeys(read("student1.classroom"));
                loginPage.nextBtn_googleCl.click();

                WebDriverWait wait = new WebDriverWait(getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordGoogleCl_Input));

                loginPage.passwordGoogleCl_Input.sendKeys(read("stud.class.psw"));
                loginPage.nextBtn_googleCl.click();
                getDriver().close();
                System.out.println("Child window closed");
            }
        }

    }

    @And("enters valid Classroom password and clicks Next")
    public void entersValidClassroomPasswordAndClicksNext() {
        loginPage.passwordGoogleCl_Input.sendKeys(read("stud.class.psw"));
        loginPage.nextBtn_googleCl.click();
    }
}
