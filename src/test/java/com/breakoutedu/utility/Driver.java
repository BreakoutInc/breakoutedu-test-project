package com.breakoutedu.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

public class Driver {

    private static WebDriver obj ;
    private static WebDriver obj2 ;

    private Driver(){ }

    public static WebDriver getDriver(){
        String browserName = ConfigReader.read("browser") ;
        if(obj == null){
            obj = getDriverBase(browserName);
        }
        return obj;
    }

    public static WebDriver getDriver2(){
        String browserName = ConfigReader.read("browser2") ;
        if(obj2 == null){
            obj2 = getDriverBase(browserName);
        }
        return obj2;
    }

    private static WebDriver getDriverBase(String browserName){
        WebDriver newDriver = null;
        // according to browser type set up driver correctly
        switch (browserName ){
            case "chrome" :
                newDriver = WebDriverManager.chromedriver().create();
                break;
            case "firefox" :
                newDriver = WebDriverManager.firefoxdriver().create();
                break;
            case "safari":
                newDriver = WebDriverManager.safaridriver().create();
                break;
            case "chromium":
                newDriver = WebDriverManager.chromiumdriver().create();
                break;
            // other browsers omitted
            default:
                newDriver = null ;
                System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
        }
        return newDriver;
    }

    public static void closeBrowser(){
        if(obj != null ){
            obj.quit();
            // when ask for it again , it gives us not quited fresh driver
            obj = null ;
        }
        if(obj2 != null ){
            obj2.quit();
            // when ask for it again , it gives us not quited fresh driver
            obj2 = null ;
        }
    }
}
