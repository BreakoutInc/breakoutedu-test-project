package com.breakoutedu.pages;

import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.utility.Driver;
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

    @FindBy (xpath = "//button[contains(text(),'LOG IN')]")
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

    public void goTo(String url){
        Driver.getDriver().navigate().to( read("url") );
    }

    public void teacherLogin(String username, String password ) {
        this.logInBtn.click();
        this.teacherBtn.click();
        this.teacherEmailInput.sendKeys(username);
        this.teacherPwdInput.sendKeys(password);
        this.teachSignInBtn.click();

    }

    public void studentLoginWthBE(String username, String password ) {
        this.logInBtn.click();
        this.studentBtn.click();
        this.logInWithBE_Btn.click();
        this.studentUsernameInput.sendKeys(username);
        this.studentPswInput.sendKeys(password);
        this.studentLogInBtn.click();

    }



    }
