package com.breakoutedu.pages.student;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StudentGamePlayerPage {


    public StudentGamePlayerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='locks']")
    public List<WebElement> locksList;

    @FindBy(xpath = "//img[contains (@src, 'keyboard')]")
    public WebElement keyboardImg;

    @FindBy(xpath = "//img[contains (@src, 'endscreens')]")
    public WebElement imageYouBrokeOut;

    @FindBy(xpath = "//div[contains (@class, 'game-play-wrapper')]")
    public WebElement elmWrapperOfOpenedGameScreen;     //displayed when game is opened

    @FindBy(xpath = "//a[contains (@class, 'close')][contains (@href, '/game/play')]")
    public WebElement closeGameIcon;

    @FindBy(xpath = "//p[contains (text(), 'Sorry, there seems to be an issue:')]")
    public WebElement errorPlayingNoLockGame;

    @FindBy(xpath = "//a[contains (text(), 'Select your first lock to begin.')]")
    public WebElement select1stLockMsg;


    public void enterGameClueCombination(String combination){
        for (int i = 0; i < combination.length(); i++) {
            Driver.getDriver().findElement(By.xpath("//div[@class='select__lock__box__inr']/h2[text()="+combination.charAt(i)+"]")).click();
        }
    }






}
