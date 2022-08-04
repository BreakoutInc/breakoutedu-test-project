package com.breakoutedu.pages.teacher;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TeacherMyGamesPage {

    public TeacherMyGamesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[contains (@class,'create-game-tab-btn')]")
    public WebElement createGameBtn;

    @FindBy(xpath = "//input[@placeholder='Search Game by Name']")
    public WebElement searchGameInput;

    @FindBy(xpath = "//input[@placeholder='Search Game by Name']/../button")
    public WebElement searchBtn;

    @FindBy(xpath = "//a[contains(@href, '/game/detail')]")
    public List<WebElement> allGamesList;

    @FindBy(xpath = "//a[contains(text(), 'Play')]")
    public List<WebElement> playBtnList;

    @FindBy(xpath = "//a[contains(@class, 'router-link')][contains (@class, 'close')]")
    public WebElement closeGameBtn;

    @FindBy(xpath = "//li[@class='locks']")
    public List<WebElement> gameLockList;

    @FindBy(xpath = "//a[contains(@class, 'copy')]")
    public List<WebElement> copyBtnList;

    @FindBy(xpath = "//a[contains(@class, 'assign')]")
    public List<WebElement> assignGameBtnList;

    @FindBy(xpath = "//a[contains(@class, 'result')]")
    public List<WebElement> resultBtnList;

    @FindBy(xpath = "//span[contains (text(), 'Share')]/..")
    public List<WebElement> shareBtnList;

    @FindBy(xpath = "//span[contains (text(), 'Embed')]/..")
    public List<WebElement> embedBtnList;

    @FindBy(xpath = "//span[contains (text(), 'Edit')]/..")
    public List<WebElement> editBtnList;

    @FindBy(xpath = "//span[contains (text(), 'Show Tags')]/..")
    public List<WebElement> showTagsBtnList;

    @FindBy(xpath = "//span[contains (text(), 'Delete')]/..")
    public List<WebElement> deleteBtnList;



}

