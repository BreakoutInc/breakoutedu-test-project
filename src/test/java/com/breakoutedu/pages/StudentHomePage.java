package com.breakoutedu.pages;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage {

public StudentHomePage(){
  PageFactory.initElements(Driver.getDriver(),this);
}


  @FindBy(xpath = "//a[text()='Change Password']")
  public WebElement changePswdBtn;

  @FindBy(xpath = "//button[text()='Logout']")
  public WebElement logoutBtn;

  @FindBy(xpath = "//a[text()='My Classes']")
  public WebElement myClassesModule;

  @FindBy(xpath = "//a[text()='My Games']")
  public WebElement myGamesModule;

  @FindBy(xpath = "//a[text()='Notifications']")
  public WebElement notificationsModule;

  @FindBy(xpath = "//a[@class='btn btn-secondary pull-right']")
  public WebElement createGameBtn;


}
