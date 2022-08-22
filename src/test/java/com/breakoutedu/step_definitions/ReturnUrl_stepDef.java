package com.breakoutedu.step_definitions;

import static com.breakoutedu.utility.ConfigReader.*;

import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.BrowserUtil.*;

import static com.breakoutedu.utility.Driver.*;

import com.breakoutedu.pages.teacher.TeacherMyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ReturnUrl_stepDef {
    BELoginPage loginPage = new BELoginPage();
    TeacherMyAccountPage myAccountPage = new TeacherMyAccountPage();


    @And("teacher logs into account")
    public void teacherLogsIntoAccount() {
        loginPage.teacherLogin(read("teacher2"),read("teacher.psw"));
    }

    @Given("teacher is on the Login Page")
    public void teacherIsOnTheLoginPage() {
        getDriver().get(read("user.url"));
    }

    @When("teacher goes to My Account url path")
    public void teacherGoesToMyAccountUrlPath() {
        getDriver().get(read("user.url")+read("my.account.path"));
    }

    @Then("LogIn page is displayed")
    public void logInPageIsDisplayed() {
        assertTrue(getDriver().getCurrentUrl().equalsIgnoreCase(read("user.url")+read("login.page.path")));
    }

    @When("teacher goes to My Classes url path")
    public void teacherGoesToMyClassesUrlPath() {
        getDriver().get(read("user.url")+read("my.classes.path"));
    }

    @When("teacher goes to My Games url path")
    public void teacherGoesToMyGamesUrlPath() {
        getDriver().get(read("user.url")+read("my.games.path"));
    }

    @When("teacher goes to Store url path")
    public void teacherGoesToStoreUrlPath() {
        getDriver().get(read("user.url")+read("shop.path"));
    }


    @When("teacher goes to Change Password url path")
    public void teacherGoesToChangePasswordUrlPath() {
        getDriver().get(read("user.url")+read("change.password.path"));
    }

    @Then("Change Password page is displayed")
    public void changePasswordPageIsDisplayed() {
       assertTrue(myAccountPage.currentPswdInput.isDisplayed());
       assertTrue(myAccountPage.verifyPswdInput.isDisplayed());

    }

    @When("teacher goes to My Account url path with returnUrl param")
    public void teacherGoesToMyAccountUrlPathWithReturnUrlParam() {
        getDriver().get(read("user.url")+read("my.account.path")+read("return.url.param")+read("user.url")+read("my.account.path"));
        System.out.println("URL="+read("user.url")+read("my.account.path")+read("return.url.param")+read("user.url")+read("my.account.path"));
    }

    @When("teacher goes to My Classes url path with returnUrl param")
    public void teacherGoesToMyClassesUrlPathWithReturnUrlParam() {
        getDriver().get(read("return.url.param")+read("user.url")+read("my.classes.path"));
    }

    @When("teacher goes to My Games url path with returnUrl param")
    public void teacherGoesToMyGamesUrlPathWithReturnUrlParam() {
        getDriver().get(read("return.url.param")+read("user.url")+read("my.games.path"));
    }

    @When("teacher goes to Store url path with returnUrl param")
    public void teacherGoesToStoreUrlPathWithReturnUrlParam() {
        getDriver().get(read("return.url.param")+read("user.url")+read("shop.path"));
    }

    @When("teacher goes to Change Password url path with returnUrl param")
    public void teacherGoesToChangePasswordUrlPathWithReturnUrlParam() {
        getDriver().get(read("return.url.param")+read("user.url")+read("change.password.path"));
    }
}
