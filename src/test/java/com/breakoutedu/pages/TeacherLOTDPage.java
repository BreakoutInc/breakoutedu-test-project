package com.breakoutedu.pages;

import static com.breakoutedu.utility.BrowserUtil.*;
import static com.breakoutedu.utility.Driver.*;

import static com.breakoutedu.utility.ConfigReader.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeacherLOTDPage {


    public TeacherLOTDPage(){
        PageFactory.initElements(getDriver(),this);
    }
    BELoginPage loginPage = new BELoginPage();

    @FindBy(xpath = "//div[@id='collapseTwo']//*[text()]")
    public WebElement lotdAnswerKey;

    @FindBy(xpath = "//a[contains (@href, 'game/lock-of-the-day')]")
    public WebElement lotdGameBanner;

    @FindBy(xpath = "//button[contains (text(), 'LOCK COMBINATIONS')]")
    public WebElement lockCombinationsBtn;


    public String getLOTDanswerKey(){
        goTo("user");
        waitForPageToLoad(5);
        loginPage.teacherLogin(read("teacher1"), read("teacher.psw"));
        lotdGameBanner.click();
        waitForPageToLoad(5);
        lockCombinationsBtn.click();
        return lotdAnswerKey.getText();
    }

}
