package com.breakoutedu.utility;
import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import com.breakoutedu.utility.BE_util;
import static com.breakoutedu.utility.BrowserUtil.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        BELoginPage loginPage = new BELoginPage();
        Faker faker = new Faker();
        BE_util beUtil = new BE_util();
        StudentHomePage homePage = new StudentHomePage();
        StudentMyGamesPage gamesPage = new StudentMyGamesPage();
        BrowserUtil browserUtil = new BrowserUtil();

        //student game play
        beUtil.goTo("student");
        beUtil.studentLoginWthBE(read("student1_user"),read("studentPassword"));
        homePage.myGamesModule.click();
        gamesPage.createNewGameBtn.click();
        gamesPage.listOfClasses.get(0).click();
        waitFor(2);
        gamesPage.createGameBtn.click();

        gamesPage.selectGameCategory("Single lock").click();
        String title =faker.animal().name();
        gamesPage.titleInput.sendKeys(title);
        gamesPage.nextBtn.click();
        gamesPage.lockStoryInput.sendKeys(faker.chuckNorris().fact());

        browserUtil.scrollToElement(gamesPage.textLockClueBtn);

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(gamesPage.textLockClueBtn));

        gamesPage.textLockClueBtn.click();
        gamesPage.textLockInput.sendKeys(faker.harryPotter().quote());
        gamesPage.selectLetterForLockClue("TEST");
        gamesPage.seqGameBtn.click();
        homePage.myGamesModule.click();
        Assert.assertTrue(gamesPage.gameIsPresentInCreatedGamesColumn(title));

        Driver.getDriver().quit();
    }
}
