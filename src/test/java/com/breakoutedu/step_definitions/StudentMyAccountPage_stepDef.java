package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.student.StudentAccountPage;
import com.breakoutedu.pages.student.StudentHomePage;
import static com.breakoutedu.utility.ConfigReader.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StudentMyAccountPage_stepDef {
    StudentHomePage homePage = new StudentHomePage();
    StudentAccountPage accountPage = new StudentAccountPage();

    @When("student clicks on account icon")
    public void studentClicksOnAccountIcon() {
     homePage.avatarIcon.click();
    }

    @And("clicks on Change password button")
    public void clicksOnChangePasswordButton() {
        accountPage.changePasswordBtn.click();
    }

    @And("fills up the form")
    public void fillsUpTheForm() {
        accountPage.currentPswInput.click();
        accountPage.currentPswInput.sendKeys(read("stud.psw"));
        accountPage.newPswInput.click();
        accountPage.newPswInput.sendKeys(read("stud.psw"));
        accountPage.verifyNewPswInput.click();
        accountPage.verifyNewPswInput.sendKeys(read("stud.psw"));
    }

    @And("clicks on Save Password")
    public void clicksOnSavePassword() {
        accountPage.savePswBtn.click();
    }

    @Then("verifies You have successfully changed your password window is displayed")
    public void verifiesYouHaveSuccessfullyChangedYourPasswordWindowIsDisplayed() {
        Assert.assertTrue(accountPage.alertPswChangedSuccessfully.isDisplayed());
    }

    @And("fills up the form with not matched confirmation password")
    public void fillsUpTheFormWithNotMatchedConfirmationPassword() {
        accountPage.currentPswInput.click();
        accountPage.currentPswInput.sendKeys(read("stud.psw"));
        accountPage.newPswInput.click();
        accountPage.newPswInput.sendKeys(read("stud.psw"));
        accountPage.verifyNewPswInput.click();
        accountPage.verifyNewPswInput.sendKeys("abc123");
    }

    @Then("verifies confirm password does not matched alert is displayed")
    public void verifiesConfirmPasswordDoesnotMatchedAlertIsDisplayed() {
        Assert.assertTrue(accountPage.alertPswDoesnotMatch.isDisplayed());
    }
}
