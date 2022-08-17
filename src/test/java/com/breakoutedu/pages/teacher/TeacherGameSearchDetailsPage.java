package com.breakoutedu.pages.teacher;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherGameSearchDetailsPage {

    public TeacherGameSearchDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[contains (@class, 'assign-game')]")
    public WebElement assignGameBtn;

}
