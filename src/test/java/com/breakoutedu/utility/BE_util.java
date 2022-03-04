package com.breakoutedu.utility;

import com.breakoutedu.pages.BELoginPage;
import com.breakoutedu.pages.TeacherHomePage;
import org.openqa.selenium.By;

import static com.breakoutedu.utility.ConfigReader.read;

public class BE_util {
    BELoginPage beLoginPage = new BELoginPage();
    TeacherHomePage teacherHomeP = new TeacherHomePage();


    public void teacherLogin(String username, String password ) {
        beLoginPage.logInBtn.click();
        beLoginPage.teacherBtn.click();
        beLoginPage.teacherEmailInput.sendKeys(username);
        beLoginPage.teacherPwdInput.sendKeys(password);
        beLoginPage.teachSignInBtn.click();

    }

    public void studentLoginWthBE(String username, String password ) {
        beLoginPage.logInBtn.click();
        beLoginPage.studentBtn.click();
        beLoginPage.logInWithBE_Btn.click();
        beLoginPage.studentUsernameInput.sendKeys(username);
        beLoginPage.studentPswInput.sendKeys(password);
        beLoginPage.studentLogInBtn.click();

    }


    public void userLogOut(){
        teacherHomeP.myAccountIcon.click();
        Driver.getDriver().findElement(By.xpath("//*[@id='accountBox']/div[3]/div/button")).click();
    }

    public void goTo(String userType){
        if(userType.equals("student")) {
            Driver.getDriver().navigate().to(read("stud_url"));
        }else if(userType.equals("user")){
            Driver.getDriver().navigate().to(read("user_url"));
        }else{
            System.out.println("Invalid user type provided");
        }
    }
}
