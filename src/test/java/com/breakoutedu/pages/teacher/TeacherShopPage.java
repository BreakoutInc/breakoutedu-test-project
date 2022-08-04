package com.breakoutedu.pages.teacher;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherShopPage {

    public TeacherShopPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[contains (@class, 'my-account-head')]")
    public WebElement pageHeaderBubble;

    // Paid User view

}
