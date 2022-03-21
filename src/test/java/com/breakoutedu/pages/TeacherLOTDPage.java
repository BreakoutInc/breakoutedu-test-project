package com.breakoutedu.pages;

import static com.breakoutedu.utility.BrowserUtil.*;
import static com.breakoutedu.utility.Driver.*;

import com.breakoutedu.utility.ConfigReader;
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

    @FindBy(xpath = "//div[@id='collapseTwo']//*[text()]")
    public WebElement lotdAnswerKey;

    @FindBy(xpath = "//a[contains (@href, 'game/lock-of-the-day')]")
    public WebElement lotdGameBanner;

    @FindBy(xpath = "//button[contains (text(), 'LOCK COMBINATIONS')]")
    public WebElement lockCombinationsBtn;



}
