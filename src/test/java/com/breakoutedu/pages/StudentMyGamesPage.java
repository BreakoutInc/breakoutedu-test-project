package com.breakoutedu.pages;

import com.breakoutedu.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StudentMyGamesPage {

    public StudentMyGamesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Create New Game']")
    public WebElement createNewGameBtn;

    @FindBy(xpath = "//*[text()='Create Game']")
    public WebElement createGameBtn;

    //after selecting lock type
    @FindBy(xpath = "//button[text()='NEXT']")
    public WebElement nextBtn;

    @FindBy(xpath = "//div[@class='lock-of-day-banner game-container']")
    public WebElement LOTDgame;

    @FindBy(xpath = "//div[contains (@class, 'radiobutton')]//input/..")
    public List<WebElement> listOfClasses;

    @FindBy(xpath = "//*[contains (text(), 'Single Lock')]/..//li")
    public WebElement singleLockBtn;

    @FindBy(xpath = "//*[contains (text(), 'Non-Sequential Game')]/..")
    public WebElement nonSeqGameBtn;

    @FindBy(xpath = "//*[contains (text(), 'One puzzle leads')]/..")
    public WebElement seqGameBtn;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleInput;

    @FindBy(xpath = "//div[@class='lock-setup-story']//div[contains (@aria-label, 'Text Editor')]")
    public WebElement lockStoryInput;

    @FindBy(xpath = "//p[text()='Select a content-type below to create a clue for this lock.']/..//li[2]")
    public WebElement textLockClueBtn;

    @FindBy(xpath = "//*[contains (text(), 'Enter the text')]/..//div[@aria-label='Rich Text Editor, main']")
    public WebElement textLockInput;

    @FindBy(xpath = "//button[contains (text(), 'SAVE AS DRAFT')]")
    public WebElement saveAsDraftBtn;

    public WebElement selectLastClassFromDropdown(){
        return this.listOfClasses.get(this.listOfClasses.size()-1);
        }


    public WebElement selectGameCategory(String categoryName) {
        switch (categoryName) {
            case "Single lock":
                return this.singleLockBtn;
            case "Non-sequential game":
                return this.nonSeqGameBtn;
            case "Sequential game":
                return this.seqGameBtn;
            default:
                System.out.println("Wrong game type provided");
                break;
        }
        return null;
    }

    public void selectLetterForLockClue(String capitalLetterCombination){
        for (int i =0; i<=capitalLetterCombination.length()-1; i++){
            Driver.getDriver().findElement(By.xpath("//a[@class='alphabets'][contains (text(), '"+capitalLetterCombination.charAt(i)+"')]")).click();
        }
    }

    public boolean gameIsPresentInCreatedGamesColumn(String gameName){
        return Driver.getDriver().findElement(By.xpath("//p[text()='Created Games']/..//p[text()='"+gameName+"']")).isDisplayed();
    }
}


