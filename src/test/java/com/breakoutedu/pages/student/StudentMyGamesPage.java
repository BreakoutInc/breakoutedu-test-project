package com.breakoutedu.pages.student;

import static com.breakoutedu.utility.BrowserUtil.*;
import static com.breakoutedu.utility.Driver.*;

import com.breakoutedu.utility.ConfigReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StudentMyGamesPage {

    public StudentMyGamesPage() {
        PageFactory.initElements(getDriver(), this);
    }

    Faker faker = new Faker();

    @FindBy(xpath = "//*[text()='Create New Game']")
    public WebElement createNewGameBtn;

    @FindBy(xpath = "//*[@id='submitted-games']/div/div[1]/div/div[1]/div/div[2]/button")    //need ID
    public WebElement submitToClassBtn;  //for first game in Created

    @FindBy(xpath = "//textarea")
    public WebElement submitGameInput;

    @FindBy(xpath = "//button[contains (text(), 'SUBMIT')]")
    public WebElement submitBtn;

    @FindBy(xpath = "//p[text()='Submitted']/following-sibling::div[@class='inline']")
    public List<WebElement> submittedGamesList;

    @FindBy(xpath = "//*[text()='Created']/..//img[contains (@src, 'ellipsis-purple-01')]")
    public List<WebElement> threeDotsIcon_Created;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editGameOption;

    @FindBy(xpath = "//span[text()='Delete']")
    public WebElement deleteGameOption;

    @FindBy(xpath = "//button[text()='YES']")
    public WebElement yesDeleteGame;

    @FindBy(xpath = "//button[text()='NO']")
    public WebElement noDeleteGame;

    @FindBy(xpath = "//div[contains (@class, 'gameTitle')]")
    public List<WebElement> gameTitleAsset;

}