package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StudentMyGamesPage {

    public StudentMyGamesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='lock-of-day-banner game-container']")
    public WebElement LOTDgame;


}
