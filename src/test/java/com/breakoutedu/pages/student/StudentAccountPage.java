package com.breakoutedu.pages.student;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.support.PageFactory;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAccountPage {

    public StudentAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains (text(), 'Change Password')]")
    public WebElement changePasswordBtn;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//input[@placeholder='Current Password']")
    public WebElement currentPswInput;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    public WebElement newPswInput;

    @FindBy(xpath = "//input[@placeholder='Verify New Password']")
    public WebElement verifyNewPswInput;

    @FindBy(xpath = "//button[contains (text(), 'SAVE PASSWORD')]")
    public WebElement savePswBtn;

    @FindBy(xpath = "//*[contains (text(), 'You have successfully changed your password')]")
    public WebElement alertPswChangedSuccessfully;

    @FindBy(xpath = "//*[contains (text(), 'Confirm password doesn')]")
    public WebElement alertPswDoesnotMatch;






}
