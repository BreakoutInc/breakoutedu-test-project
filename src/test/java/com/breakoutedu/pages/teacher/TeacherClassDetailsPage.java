package com.breakoutedu.pages.teacher;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.breakoutedu.utility.Driver.getDriver;

public class TeacherClassDetailsPage {

    public TeacherClassDetailsPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "//button[contains (text(), 'Roster')]")
    public WebElement roster;

    @FindBy(xpath = "//button[contains (text(), 'Assigned Games')]")
    public WebElement assignedGames;

    @FindBy(xpath = "//button[contains (text(), 'Lock of The Day')]")
    public WebElement LOTD;

    @FindBy(xpath = "//button[contains (text(), 'Submitted Games')]")
    public WebElement submittedGames;

    @FindBy(xpath = "//button[contains (text(), 'Class Library')]")
    public WebElement classLibrary;

    @FindBy(xpath = "//div[@id='ClassDetailAccountHead']/p")
    public WebElement classTitleBubble;


}
