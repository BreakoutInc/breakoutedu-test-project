package com.breakoutedu.pages.teacher;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherHomePage {

    public TeacherHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/profile']/div")
    public WebElement myAccountIcon;

    @FindBy(xpath = "//span[text()=' My Classes']")
    public WebElement myClassesModule;

    @FindBy(xpath = "//span[text()=' My Games']']")
    public WebElement myGamesModule;

    @FindBy(xpath = "//span[text()='Notifications']")
    public WebElement notificationsModule;

    @FindBy(xpath = "//span[text()='Shop']")
    public WebElement shopModule;

    @FindBy(xpath = "//span[text()='Help']")
    public WebElement helpModule;

    @FindBy(xpath = "//div[@class='verify-badge']")
    public WebElement verifyBtn;

    @FindBy(xpath = "//input[@placeholder='Search games']")
    public WebElement gameSearchBox;

    @FindBy(xpath = "//button[@id='digital']")
    public WebElement digitalGameFilterBtn;

    @FindBy(xpath = "//button[@id='kit']")
    public WebElement kitGameFilterBtn;

    @FindBy(xpath = "//button[@id='all']")
    public WebElement allGameFilterBtn;

    @FindBy(xpath = "//button[@id='searchFilter']")
    public WebElement filterGameSearchBtn;

    @FindBy(xpath = "//*[@id='page-content']//section/div/div[1]/div[2]/button")
    public WebElement goSearchBtn;



}
