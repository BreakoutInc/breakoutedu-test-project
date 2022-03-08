package com.breakoutedu.utility;
import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;

import static com.breakoutedu.utility.BrowserUtil.*;
import com.github.javafaker.Faker;
import org.junit.Assert;


import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        BELoginPage loginPage = new BELoginPage();
        Faker faker = new Faker();
        StudentHomePage homePage = new StudentHomePage();
        StudentMyGamesPage gamesPage = new StudentMyGamesPage();


        //student game play
        goTo("student");
        loginPage.studentLoginWthBE(read("student1_user"),read("studentPassword"));
        homePage.myGamesModule.click();
        gamesPage.createNewGameBtn.click();
        gamesPage.listOfClasses.get(0).click();
        waitFor(2);
        gamesPage.createGameBtn.click();


        gamesPage.selectGameCategory("Single lock").click();
        String title =faker.company().buzzword();
        gamesPage.titleInput.sendKeys(title);
        gamesPage.nextBtn.click();
        gamesPage.lockStoryInput.sendKeys(faker.chuckNorris().fact());

        scrollToElement(gamesPage.textLockClueBtn);
        //waitFor(1);
        clickWithJS(gamesPage.textLockClueBtn);

//        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.elementToBeClickable(gamesPage.textLockClueBtn));

        //gamesPage.textLockClueBtn.click();
          gamesPage.textLockInput.sendKeys(faker.harryPotter().quote());
          waitFor(2);
          gamesPage.selectLetterForLockClue("TEST");
          scrollToElement(gamesPage.saveAsDraftBtn);
        //  waitFor(2);
         clickWithJS(gamesPage.saveAsDraftBtn);
    homePage.myGamesModule.click();
    waitForPageToLoad(5);
        System.out.println("Boolean"+gamesPage.gameIsPresentInCreatedGamesColumn(title));
    Assert.assertTrue(gamesPage.gameIsPresentInCreatedGamesColumn(title));

     // Driver.getDriver().quit();
    }
}
