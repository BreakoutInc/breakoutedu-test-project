package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StudentMyClassesPage {

    public StudentMyClassesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Assigned Games']")
    public WebElement assignedGamesTab;

    @FindBy(xpath = "//span[text()='Student Games']")
    public WebElement studentGamesTab;

    @FindBy(xpath = "//span[text()='+ Add Classroom']")
    public WebElement addClassroomBtn;

    @FindBy (xpath = "//div[@class='title']")
    List<WebElement> allClasses;

    public int ammountOfClasses(){
       return this.allClasses.size();
    }


}
