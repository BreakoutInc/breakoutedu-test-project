package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentGameDetailPage {

    public StudentGameDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[contains (text(), 'Game Detail')]")
    public WebElement gameDetailsTitle;


}
