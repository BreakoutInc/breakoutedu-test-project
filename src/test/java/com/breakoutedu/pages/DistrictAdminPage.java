package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DistrictAdminPage {

    public DistrictAdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains (text(), 'Manage District')]/..")
    public WebElement manageDistrictBtn;

    @FindBy(xpath = "//div[@class='__imgInr']")
    public WebElement accountIconBtn;

    //button under district icon to change district school
    @FindBy(xpath = "//span[contains (text(), 'Change')]")
    public WebElement changeSchoolBtn;

    @FindBy(xpath = "//p[contains (text(), 'Users')]/..")
    public WebElement usersDropdown;

    @FindBy(xpath = "//p[contains (text(), 'Teachers')]/..")
    public WebElement teachersOption;

    @FindBy(xpath = "//p[contains (text(), 'Students')]/..")
    public WebElement studentsOption;

    @FindBy(xpath = "//p[contains (text(), 'Classes')]/..")
    public WebElement classesOption;

    @FindBy(xpath = "//p[contains (text(), 'Account Settings')]/..")
    public WebElement accountSettingDropdown;

    @FindBy(xpath ="//p[contains (text(), 'Manage Profile')]/..")
    public WebElement manageProfileOption;

    @FindBy(xpath = "//label[text()='School Name']/../input")
    public WebElement schoolNameInput;

    @FindBy(xpath = "//button[text()='Update Profile']")
    public WebElement updateProfileBtn;



}
