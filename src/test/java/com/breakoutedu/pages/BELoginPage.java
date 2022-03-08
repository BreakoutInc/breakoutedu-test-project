package com.breakoutedu.pages;

import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BELoginPage {

    public BELoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains (@id, 'dropdown-menu-parent')]")
    public WebElement resourcesDropdown;

    @FindBy(xpath = "//a[@aria-label = 'Pricing']")
    public WebElement pricing;

    @FindBy (xpath = "//div[@aria-label = 'Sign Up']")
    public WebElement signUpBtn;

    @FindBy (xpath = "//a[contains(text(),'Log In')]")
    public WebElement logInBtn;

    @FindBy (xpath = "//*[text()=' Educators! Sign Up for a 2-Week FREE Trial ']")
    public WebElement LongTextSignUpBtn;

    //same for login and sign up
    @FindBy (css = ".freetrial-teacherbutton")
    public WebElement teacherBtn;

    //same for login and sign up
    @FindBy (css = ".freetrial-studentbutton")
    public WebElement studentBtn;

    //----------teacher Log In --------------
    @FindBy (xpath = "//input[@id='email']")
    public WebElement teacherEmailInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement teacherPwdInput;

    @FindBy(xpath = "//button[@type='submit'][text()='SIGN IN']")
    public WebElement teachSignInBtn;

    @FindBy(xpath = "//li[contains (text(), 'Invalid credentials')]")
    public WebElement teacherErrorMsg;


     //----------student Log In --------------
    @FindBy (xpath = "//a[text()=' Log In With Breakout EDU']")
    public WebElement logInWithBE_Btn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement studentUsernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement studentPswInput;

    @FindBy (xpath = "//button[text()='LOG IN']")
    public WebElement studentLogInBtn;

    @FindBy(xpath = "//div[@id='errors']//ul")
    public WebElement errorMsg;



    //*******************METHODS********************


    }
