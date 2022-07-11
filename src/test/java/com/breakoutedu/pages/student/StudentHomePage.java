package com.breakoutedu.pages.student;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {

public StudentHomePage(){
  PageFactory.initElements(Driver.getDriver(),this);
}


// Home page also includes Notifications

  @FindBy(xpath = "//a[text()='My Classes']")
  public WebElement myClassesModule;

  @FindBy(xpath = "//span[contains (text(), 'My Games')]")
  public WebElement myGamesModule;

  @FindBy(xpath = "//span[contains (text(), 'Home')]")
  public WebElement homeModule;

  @FindBy(xpath = "//span[contains (text(), 'Notifications')]")
  public WebElement notificationsModule;

  @FindBy(xpath = "//a[contains (@href, '/game/play/new-assignment')]")
  public WebElement gameNewAssignment;

  @FindBy(xpath = "//div[@id='lockOfDayCard']//img[contains (@src, 'playnow')]")
  public WebElement lotdPlayBanner;

  @FindBy(xpath = "//*[@id='full_avatar']")
  public WebElement avatarIcon;


  //----------Notifications-------------

  @FindBy(xpath = "//span[contains (text(), 'assigned a game')]")
  public WebElement notificAssignedGame;

  @FindBy(xpath = "//ul[contains (@class, 'scroll')]")
  public WebElement notificationsElement;

  @FindBy(xpath = "//img[contains (@src, '/exit')]")
  public WebElement closeNotificatonsIcon;

  @FindBy(xpath = "//p[text()='Notifications']")
  public WebElement notificationTitle;  //to verify it's opened/closed

  @FindBy(xpath = "//span[contains (text(), 'revise your game')]")
  public WebElement notificationToReviseGame;






}
