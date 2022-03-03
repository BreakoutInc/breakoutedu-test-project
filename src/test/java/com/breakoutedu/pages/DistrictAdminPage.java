package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//label[@for='uploadImage']")
    public WebElement uploadImageBtn;

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

    @FindBy(xpath = "//*[contains(text(), 'View Site')]")
    public WebElement viewSiteBtn;

    @FindBy(xpath = "//*[contains(text(), 'Switch Schools')]")
    public WebElement switchSchoolsBtn;

    @FindBy(xpath = "//*[contains(text(), 'Sign out')]")
    public WebElement signOutBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchTeacherInput;

    @FindBy(xpath = "//*[contains(@class, 'fa-search')]")
    public WebElement searchIcon;

    //---------------calendar--------------------------
    @FindBy(xpath = "//input[@id='filterRecord']")
    public WebElement selectDateBtn;

    @FindBy(xpath = "//*[@class='prev available']")
    public WebElement navigateBackInCalendar;

    @FindBy(xpath = "//*[@class='next available']")
    public WebElement navigateForwardInCalendar;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement cancelBtnInCalendar;

    @FindBy(xpath = "//button[text()='Apply']")
    public WebElement applyBtnInCalendar;

    @FindBy(xpath = "//*[contains(@class, 'myClearAll')]")
    public WebElement clearCalendarSelectionBtn;

    public void clickOnDayInCalendar(String day){
        Driver.getDriver().findElement(By.xpath("//td[contains (text(), '"+day+"')]")).click();
    }

    
    public WebElement SwitchSchoolFromDropdown(String schoolName){
      return  Driver.getDriver().findElement(By.xpath("//*[contains(text(), '"+schoolName+"')]"));
    }



}
