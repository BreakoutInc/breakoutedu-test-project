package com.breakoutedu.utility;
import com.breakoutedu.pages.BELoginPage;
import static com.breakoutedu.utility.ConfigReader.*;
import com.breakoutedu.pages.StudentHomePage;
import com.breakoutedu.pages.StudentMyGamesPage;

import static com.breakoutedu.utility.BrowserUtil.*;
import com.github.javafaker.Faker;
import org.junit.Assert;


import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test {


    public static void main(String[] args) {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
//        BELoginPage loginPage = new BELoginPage();
//        Faker faker = new Faker();
//        StudentHomePage homePage = new StudentHomePage();
//        StudentMyGamesPage gamesPage = new StudentMyGamesPage();


        //student game play
      goTo("student");
//        loginPage.studentLoginWthBE(read("student1"),read("stud.psw"));

     // Driver.getDriver().quit();
      //  System.out.println(read("file.name"));
    }
}
