package com.breakoutedu.step_definitions;

import io.cucumber.java.en.And;
import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;
import static com.breakoutedu.utility.BrowserUtil.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.breakoutedu.utility.BrowserUtil.*;
import static org.junit.Assert.*;
import java.util.List;

public class StudentDeleteGame_stepDef {
    BELoginPage loginPage = new BELoginPage();
    Faker faker = new Faker();
    StudentHomePage homePage = new StudentHomePage();
    StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    //--------
    Integer ammountOfGames =gamesPage.threeDotsIcon_Created.size();

    @When("clicks on three dots icon")
    public void clicks_on_three_dots_icon() {
        System.out.println(ammountOfGames+" ammount");
     gamesPage.threeDotsIcon_Created.get(0).click();
    }
    @And("clicks on delete button")
    public void clicks_on_delete_button() {
     gamesPage.deleteGameOption.click();
    }
    @And("selects yes on popped up window")
    public void selects_yes_on_popped_up_window() {
        waitForClickability(gamesPage.yesDeleteGame, 3);
     clickWithJS(gamesPage.yesDeleteGame);
     waitFor(2);
    }
    @Then("verifies the game was delete")
    public void verifies_the_game_was_delete() {
    int updatedAmmountOfGames = gamesPage.threeDotsIcon_Created.size();
        System.out.println(updatedAmmountOfGames+" new ammount");
        assertEquals(updatedAmmountOfGames + 1, (int) ammountOfGames);
    }

}
