package com.breakoutedu.pages.teacher;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TeacherMyClassesPage {

    public TeacherMyClassesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//p[contains(text(), 'Create Class')]")
    public WebElement createClassBtn;

    @FindBy(xpath = "//div[@id='swal2-content']//input")
    public WebElement newClassNameInput;

    @FindBy(xpath = "//button[@class='join-btn']")
    public WebElement joinClassEmptyClassCard;

    @FindBy(xpath = "//button[@data-target='#digitalGame']")
    public WebElement digitalGamesDropdown;

    @FindBy(xpath = "//button[@data-target='#myClasses']")
    public WebElement myClassesDropdown;

    @FindBy(xpath = "//span[text()='My Digital Games']")
    public WebElement myDigitalGamesOption;

    @FindBy(xpath = "//span[text()='Draft Games']")
    public WebElement draftGamesOption;

    @FindBy(xpath = "//span[contains (text(), 'My Archived')]")
    public WebElement myArchivedClassesOption;

    @FindBy(xpath = "//a[@href='/bookmarked-games']")
    public WebElement bookmarkedGamesModule;

    @FindBy(xpath = "//a[@href='/payments']")
    public WebElement myPaymentsModule;

    @FindBy(xpath = "//*[contains (text(), 'Student Design')]")
    public WebElement studentDesignCourse;

    @FindBy(xpath = "//a[contains(@href, '/sync-classes/google')]")
    public WebElement importWithGoogleClassroom;

    @FindBy(xpath = "//a[contains(@href, '/sync-classes/microsoft')]")
    public WebElement importWithMicrosoft;

    @FindBy(xpath = "//a[contains(@href, '/sync-classes/classkink')]")
    public WebElement importWithClasslink;

    @FindBy (xpath = "//tbody//a[contains (@href, '/class-students-submitted/')]")
    public List<WebElement> listOfAllClasses;

    @FindBy(xpath = "//tbody//a[contains (@href, '/submitted-game/')]")
    public WebElement submittedGamesBtn;

    @FindBy(xpath = "//tbody//a[contains (@href, '/class/managegames/')]")
    public WebElement manageAssignedGames;

    @FindBy(xpath = "//tbody//a[contains (@href, '/class/manage-library')]")
    public WebElement manageGameLibrary;

    @FindBy(xpath = "//tbody//a[contains (@href, '/class/manage-lock-of-day')]")
    public WebElement lotdGamesManage;

    @FindBy(xpath = "//*[contains (text(), 'Edit')]")
    public WebElement editClassBtn;

    @FindBy(xpath = "//*[contains (text(), 'Shuffle Code')]")
    public WebElement shuffleCodeBtn;

    @FindBy(xpath = "//*[contains (text(), 'Archive Class')]")
    public WebElement archiveClassBtn;

    @FindBy(xpath = "//*[contains (text(), 'Delete')]")
    public WebElement deleteBtn;











}
