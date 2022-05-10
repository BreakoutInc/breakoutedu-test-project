package com.breakoutedu.pages;

import com.breakoutedu.utility.ConfigReader;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;
import static com.breakoutedu.utility.BrowserUtil.clickWithJS;
import static com.breakoutedu.utility.BrowserUtil.scrollToElement;
import static com.breakoutedu.utility.Driver.getDriver;

public class StudentCreatesGamePage {
    public StudentCreatesGamePage() {
        PageFactory.initElements(getDriver(), this);
    }

    Faker faker = new Faker();

    //after selecting lock type
    @FindBy(xpath = "//button[text()='NEXT']")
    public WebElement nextBtn;

    @FindBy(xpath = "//div[@class='lock-of-day-banner game-container']")
    public WebElement LOTDgame;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createGameBtn;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> listOfClasses;

    @FindBy(xpath = "//*[contains (text(), 'Single Lock')]/..//li")
    public WebElement singleLockBtn;

    @FindBy(xpath = "//*[contains (text(), 'Non-Sequential Game')]")
    public WebElement nonSeqGameBtn;

    @FindBy(xpath = "//*[contains (text(), 'One puzzle leads')]/..")
    public WebElement seqGameBtn;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleInput;

    @FindBy(xpath = "//div[@class='lock-setup-story']//div[contains (@aria-label, 'Text Editor')]")
    public WebElement lockStoryInputSingleLock;

    @FindBy(xpath = "//h2[text()='Text']")
    public WebElement textLockClueBtn;

    @FindBy(xpath = "//*[contains (text(), 'Enter the text')]/..//div[@aria-label='Rich Text Editor, main']")
    public WebElement textLockInput;

    @FindBy(xpath = "NAAAAAAAAAAAAA")
    public WebElement additionalLockStoryInput;

    @FindBy(xpath = "//*[@id='locksetupstory']//div[@role='textbox']")
    public WebElement lockStoryInputMultiL;

    @FindBy(xpath = "//button[contains (text(), 'SAVE AS DRAFT')]")
    public WebElement saveAsDraftBtn;

    @FindBy(xpath = "//*[@id='edit-game-tabs']/li[2]/a")
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

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//textarea[contains (@placeholder, 'embed video code')]")
    public WebElement embedCodeInput;

    @FindBy(xpath = "//*[@id='myTabContent']/div[2]/div[3]/button[1]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//*[@id='myTabContent']/div[6]/div[3]/button[2]") //??
    public WebElement deleteLockBtn;

    @FindBy(xpath = "//*[@id='myTabContent']/div[6]/div[3]/div/button[1]") //??
    public WebElement saveAsDraftBtnMultiLock;

    @FindBy(xpath = "//*[@id='myTabContent']/div[6]/div[3]/div/button[2]")  //??
    public WebElement addAnotherLockBtn;

    @FindBy(xpath = "//*[@id='myTabContent']/div[6]/div[3]/div/button[3]") //??
    public WebElement saveAndExitBtn;

    @FindBy(xpath = "//button[contains (text(), 'SAVE AND PLAY')]")
    public WebElement saveAndPlayBtn;

    @FindBy(xpath = "//div[@class='alert__icon']") //??
    public WebElement alertForWrongTitle;

    @FindBy(xpath = "//img[@id='blah']")
    public WebElement uploadImgAssert;

    @FindBy(xpath = "//*[contains (text(),'Unsupported image type')]")
    public WebElement unsupportedMediaTypeErrorMsg;

    @FindBy(xpath = "//*[contains (text(), 'less than or equal to 5mb')]")
    public WebElement imageTooLargeErrorMsg;

    @FindBy(xpath = "//div[@id='swal2-validation-message']")
    public WebElement submitWthNoCommentError;

    @FindBy(xpath = "//div[@class='alert__icon']")
    public WebElement alertForNoLockClueText;

    //////////////METHODS//////////////////////////////

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

    public void selectLockClue(String lockClue){
        //   Options: Image, Text, Video Embed Code
        if(lockClue.equals("Image") || lockClue.equals("Text") || lockClue.equals("Video Embed Code")) {
            clickWithJS(getDriver().findElement(By.xpath("//h2[text()='" + lockClue + "']")));
        }else{
            System.out.println("Wrong lock clue text provided. Correct inputs are: Image, Text, Video Embed Code");
        }
    }

    //------select lock clue combinations
    public void selectLetterForLockClue(String capitalLetterCombination){
        for (int i =0; i<capitalLetterCombination.length(); i++){
            clickWithJS(getDriver().findElement(By.xpath("//a[@class='alphabets'][contains (text(), '"+capitalLetterCombination.charAt(i)+"')]")));
        }
    }

    public void selectNumbersForLockClue(String numberCombination) {
        for (int i = 0; i < numberCombination.length(); i++) {
            clickWithJS(getDriver().findElement(By.xpath("//a[@class='numbers'][contains (text(), '" + numberCombination.charAt(i) + "')]")));
        }
    }

    public void selectDirectionForLockClue(String firstLettersOfDirectionCombination) {

        //possible directions Up, Down, Right, Left -> ex UULR
        for (int i = 0; i < firstLettersOfDirectionCombination.length(); i++) {
            if (firstLettersOfDirectionCombination.charAt(i) == 'U') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-direction='up']")));
            } else if (firstLettersOfDirectionCombination.charAt(i) == 'D') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-direction='down']")));
            } else if (firstLettersOfDirectionCombination.charAt(i) == 'L') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-direction='left']")));
            } else if (firstLettersOfDirectionCombination.charAt(i) == 'R') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-direction='right']")));
            } else {
                System.out.println("Wrong letter combination provided - make sure to use capital first letter of each direction");
            }
        }
    }

    public void selectShapeForLockClue(String firstLetterOfShapeCombination){

        // provide first capital letter of each shape. Options: Rectangular(Square), Circle, Triangle, Diamond, Star -> Ex: RCTS

        for (int i = 0; i < firstLetterOfShapeCombination.length(); i++) {
            if (firstLetterOfShapeCombination.charAt(i) == 'R') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-shape='square']")));
            } else if (firstLetterOfShapeCombination.charAt(i) == 'C') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-shape='circle']")));
            } else if (firstLetterOfShapeCombination.charAt(i) == 'T') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-shape='triangle']")));
            } else if (firstLetterOfShapeCombination.charAt(i) == 'D') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-shape='diamond']")));
            }else if(firstLetterOfShapeCombination.charAt(i) == 'S'){
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-shape='star']")));
            } else {
                System.out.println("Wrong letter combination provided - make sure to use capital first letter of each direction");
            }
        }
    }

    public void selectColorForLockClue(String firstLetterOfColorCombination){

        // provide first capital letter of each color, EXCEPT(Blue -N, Black - X, Gray - Q
        // Options: Red, Green, Orange, Navy(blue), Brown, Yellow, Purple, Grey(Q), White, Black(X)

        for (int i = 0; i < firstLetterOfColorCombination.length(); i++) {
            if (firstLetterOfColorCombination.charAt(i) == 'R') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='red']")));
            } else if (firstLetterOfColorCombination.charAt(i) == 'G') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='green']")));
            } else if (firstLetterOfColorCombination.charAt(i) == 'O') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='orange']")));
            } else if (firstLetterOfColorCombination.charAt(i) == 'N') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='blue']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'B') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='brown']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'Y') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='yellow']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'P') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='purple']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'Q') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='grey']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'W') {
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='white']")));
            }else if(firstLetterOfColorCombination.charAt(i) == 'X'){
                clickWithJS(getDriver().findElement(By.xpath("//a[@data-color='black']")));
            } else {
                System.out.println("Wrong letter combination provided - make sure to use capital first letter of each direction");
            }
        }
    }

    public boolean gameIsPresentInCreatedGamesColumn(String gameName){
        return getDriver().findElement(By.xpath("//p[text()='Created']/..//p[text()='"+gameName+"']")).isDisplayed();
    }

    public String getGameNameFromCreatedColumn(){
        return getDriver().findElement(By.xpath("//div[contains (@class, 'gameTitle')]/p")).getText();
    }

    public void createLockForMultlGame(String lockType, String lockClue, String lockCombination) {
        //----lines below are for starting game
//        this.selectLockTypeForMultilockGame(lockType).click();
//        this.lockStoryInputMultiL.click();   //????? maybe don't need
//        this.lockStoryInputMultiL.sendKeys(faker.backToTheFuture().quote());
//        this.textLockClueBtn.click();
//        this.textLockInput.sendKeys(faker.aquaTeenHungerForce().character());
        scrollToElement(this.addNewLock);
        clickWithJS(addNewLock);
        clickWithJS(this.selectLockTypeForMultilockGame(lockType));
        this.lockStoryInputMultiL.click();
        this.lockStoryInputMultiL.sendKeys(faker.hitchhikersGuideToTheGalaxy().quote());
        this.selectLockClue(lockClue);

        switch (lockClue) {
            case "Image":
                this.uploadFile.sendKeys(ConfigReader.read("image.path"));
                break;
            case "Text":
                this.textLockInput.click();
                textLockInput.sendKeys(faker.friends().quote());
                break;
            case "Video Embed Code":
                this.embedCodeInput.sendKeys("<iframe width='560' height='315' src='https://www.youtube.com/embed/1QTc2nDP49A' title='YouTube video player' " +
                        "frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>");
                break;
            default:
                System.out.println("Wrong lock clue provided");
                break;
        }

        switch (lockType) {
            case "text":
                this.selectLetterForLockClue(lockCombination);
                break;
            case "number":
                this.selectNumbersForLockClue(lockCombination);
                break;
            case "directional":
                this.selectDirectionForLockClue(lockCombination);
                break;
            case "shape":
                this.selectShapeForLockClue(lockCombination);
                break;
            case "color":
                this.selectColorForLockClue(lockCombination);
                break;
            default:
                System.out.println("Wrong lock clue type provided, make sure it's all lower case");
                break;


        }

    }

    // creates lock for multil game with ability to provide custom image file type from properties file
    public void createLockForMultlGame(String lockType, String lockClue, String lockCombination, String imageType) {
        scrollToElement(this.addNewLock);
        clickWithJS(addNewLock);
        clickWithJS(this.selectLockTypeForMultilockGame(lockType));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(this.lockStoryInputMultiL).click().sendKeys(faker.hitchhikersGuideToTheGalaxy().quote()).perform();
//        this.lockStoryInputMultiL.click();
//        this.lockStoryInputMultiL.sendKeys(faker.hitchhikersGuideToTheGalaxy().quote());
        this.selectLockClue(lockClue);

        switch (lockClue) {
            case "Image":
                this.uploadFile.sendKeys(ConfigReader.read(imageType));
                break;
            case "Text":
                this.textLockInput.click();
                textLockInput.sendKeys(faker.friends().quote());
                break;
            case "Video Embed Code":
                this.embedCodeInput.sendKeys("<iframe width='560' height='315' src='https://www.youtube.com/embed/1QTc2nDP49A' title='YouTube video player' " +
                        "frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>");
                break;
            default:
                System.out.println("Wrong lock clue provided");
                break;
        }

        switch (lockType) {
            case "text":
                this.selectLetterForLockClue(lockCombination);
                break;
            case "number":
                this.selectNumbersForLockClue(lockCombination);
                break;
            case "directional":
                this.selectDirectionForLockClue(lockCombination);
                break;
            case "shape":
                this.selectShapeForLockClue(lockCombination);
                break;
            case "color":
                this.selectColorForLockClue(lockCombination);
                break;
            default:
                System.out.println("Wrong lock clue type provided, make sure it's all lower case");
                break;


        }

    }

    public WebElement submitBtnForGivenGame(String gameName){
        return getDriver().findElement(By.xpath("//p[text()='"+gameName+"']/ancestor::div[@class='inline']//p[contains (text(), 'Submit to Class')]"));
    }





}


