package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentSignUpPage {

    public StudentSignUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains (@href, 'register')]")
    public WebElement signUphere;

    @FindBy(xpath = "//a[text()=' Signup With Breakout EDU']")
    public WebElement signupWithBE;

    @FindBy(id = "//a[@id='student_google_login']")
    public WebElement googleSignUp;

    @FindBy(xpath = "//input[@name='classCode']")
    public WebElement classCodeInput;

    @FindBy(xpath = "//a//a[@id='load1']")
    public WebElement nextBtn_step1;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameInput;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy (xpath = "//a[@class='btn btn-primary pul-lft'][@href='#signUpStep_1']")
    public WebElement goBackBtn_step2;

    @FindBy (xpath = "//a[@id='load2']")
    public WebElement nextBtn_step2;

    @FindBy (xpath = "//a[@class='btn btn-primary pul-lft'][@href='#signUpStep_2']")
    public WebElement goBackBtn_step3;

    @FindBy (xpath = "//a[@id='load3']")
    public WebElement nextBtn_step3;






}
