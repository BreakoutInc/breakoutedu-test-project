package com.breakoutedu.utility;


import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
//        BELoginPage loginPage = new BELoginPage();
//        Faker faker = new Faker();
//        StudentHomePage homePage = new StudentHomePage();
//        StudentMyGamesPage gamesPage = new StudentMyGamesPage();

    }
}
