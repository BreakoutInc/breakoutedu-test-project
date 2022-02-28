package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentSignUpPage {

    public StudentSignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Signup With Breakout EDU']")
    WebElement signupWithBE;

    @FindBy(id = "//a[@id='student_google_login']")
    WebElement googleSignUp;

    @FindBy(xpath = "//input[@name='classCode']")
    WebElement classCodeInput;

    @FindBy(xpath = "//a//a[@id='load1']")
    WebElement nextBtn_step1;

    @FindBy (xpath = "//input[@name='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameInput;

    @FindBy (xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy (xpath = "//a[@class='btn btn-primary pul-lft'][@href='#signUpStep_1']")
    WebElement goBackBtn_step2;

    @FindBy (xpath = "//a[@id='load2']")
    WebElement nextBtn_step2;

    @FindBy (xpath = "//a[@class='btn btn-primary pul-lft'][@href='#signUpStep_2']")
    WebElement goBackBtn_step3;

    @FindBy (xpath = "//a[@id='load3']")
    WebElement nextBtn_step3;






}
