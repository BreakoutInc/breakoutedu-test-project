package com.breakoutedu.step_definitions;

import com.breakoutedu.pages.teacher.TeacherClassDetailsPage;
import com.breakoutedu.pages.teacher.TeacherMyClassesPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class createClass_stepDef {
    TeacherMyClassesPage myClassesPage = new TeacherMyClassesPage();
    TeacherClassDetailsPage classDetailsPage = new TeacherClassDetailsPage();
    Faker faker = new Faker();

    String classTitle = faker.name().username();


    @When("teacher clicks on Create Class btn")
    public void teacherClicksOnCreateClassBtn() {

    }

    @And("provides class title and clicks Save")
    public void providesClassTitleAndClicksSave() {
        myClassesPage.newClassNameInput.click();
        myClassesPage.newClassNameInput.sendKeys(classTitle);
    }

    @Then("verifies class details page is displayed")
    public void verifiesClassPageIsDisplayed() {
        assertTrue(classDetailsPage.classTitleBubble.getText().equals(classTitle));
        assertTrue(classDetailsPage.roster.isDisplayed());
    }

    @And("clicks on create class btn")
    public void clicksOnCreateClassBtn() {
        myClassesPage.createClassBtn.click();
    }

    @Then("verifies class was created successfully")
    public void verifiesClassWasCreatedSuccessfully() {

    }

    @And("clicks on empty class card")
    public void clicksOnEmptyClassCard() {
        myClassesPage.joinClassEmptyClassCard.click();
    }
}
