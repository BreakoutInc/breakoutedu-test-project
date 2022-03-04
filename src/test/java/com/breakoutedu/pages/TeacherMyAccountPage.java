package com.breakoutedu.pages;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherMyAccountPage {

    public TeacherMyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='username'][@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='username'][@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='username'][@placeholder='Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//span[text()=' Save Changes']/..")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//*[@id='accountBox']/div[3]/div/a/button/span[2]")
    public WebElement changePswdBtn;

    @FindBy(xpath = "//*[@id='accountBox']/div[3]/div/button")
    public WebElement logoutBtn;

    @FindBy(xpath = "//div[text()='Renew With Credit Card']")
    public WebElement renewWithCC_Btn;

    @FindBy(xpath = "//*[@id='accountBox']/div[2]//a[2]/button/div")
    public WebElement orderWithPurchOrder_Btn;

    @FindBy(xpath = "//input[@placeholder='Enter School/Access Code']")
    public WebElement enterSchoolCodeInput;

    @FindBy(xpath = "//div[contains(text(), 'Enter Code')]")
    public WebElement enterCodeBtn;


    //change password form --------------------------------------------
    @FindBy(xpath = "//input[@placeholder='Current Password']")
    public WebElement currentPswdInput;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    public WebElement newPswdInput;

    @FindBy(xpath ="//input[@placeholder='Confirm Password']")
    public WebElement verifyPswdInput;

    @FindBy(xpath = "//div[contains(@class,'save-pswrd')]//button[@type='submit']")
    public WebElement savePswdBtn;






}
