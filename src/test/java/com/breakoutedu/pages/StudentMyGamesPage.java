package com.breakoutedu.pages;

import com.breakoutedu.utility.BrowserUtil;
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

    @FindBy(xpath = "//h2[text()='Text']")
    public WebElement textLockClueBtn;

    @FindBy(xpath = "//*[contains (text(), 'Enter the text')]/..//div[@aria-label='Rich Text Editor, main']")
    public WebElement textLockInput;

    @FindBy(xpath = "//button[contains (text(), 'SAVE AS DRAFT')]")
    public WebElement saveAsDraftBtn;

    @FindBy(xpath = "//*[@id='edit-game-tabs']/li[2]/a/img")
    public WebElement addNewLock;

    @FindBy(xpath = "//a[@href='#selectLockText']")
    public WebElement textLockTypeForMultiLock;

    @FindBy(xpath = "//a[@href='#selectLockNumber']")
    public WebElement numberLockTypeForMultilock;

    @FindBy(xpath = "//a[@href='#selectLockDirection']")
    public WebElement directionalLockTypeForMultilock;

    @FindBy(xpath = "//a[@href='#selectLockShape']")
    public WebElement shapeLockTypeForMultilock;

    @FindBy(xpath = "//a[@href='#selectLockColor']")
    public WebElement colorLockTypeForMultilock;

    public WebElement selectLockTypeForMultilockGame(String lockType){
        switch (lockType){
            case "text":
                return this.textLockTypeForMultiLock;
            case "number":
                return this.numberLockTypeForMultilock;
            case "directional":
                return this.directionalLockTypeForMultilock;
            case "shape":
                return this.shapeLockTypeForMultilock;
            case "color":
                return this.colorLockTypeForMultilock;
            default:
                System.out.println("Wrong lock clue type provided, make sure it's all lower case");
                return null;
        }
    }



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
        for (int i =0; i<capitalLetterCombination.length(); i++){
            BrowserUtil.clickWithJS(Driver.getDriver().findElement(By.xpath("//a[@class='alphabets'][contains (text(), '"+capitalLetterCombination.charAt(i)+"')]")));
        }
    }

    public boolean gameIsPresentInCreatedGamesColumn(String gameName){
        return Driver.getDriver().findElement(By.xpath("//p[text()='Created Games']/..//p[text()='"+gameName+"']")).isDisplayed();
    }

    public void createLockForMultilockGame(){
        this.selectLockTypeForMultilockGame("color").click();
    }

}


