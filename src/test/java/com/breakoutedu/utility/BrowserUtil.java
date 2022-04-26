package com.breakoutedu.utility;

import org.junit.Assert;

import static com.breakoutedu.utility.ConfigReader.read;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class BrowserUtil {

    public static void goTo(String userType){
        if(userType.equals("student")) {
            Driver.getDriver().navigate().to(read("stud.url"));
        }else if(userType.equals("user")){
            Driver.getDriver().navigate().to(read("user.url"));
        }else{
            System.out.println("Invalid user type provided");
        }
    }



    //wait for given amount of seconds
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //check if element is visible
    public static boolean checkVisibilityOfElement(By locator , int timeToWait ){

        boolean result = false ;

        WebDriverWait wait = new WebDriverWait(Driver.getDriver() ,timeToWait ) ;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated( locator  ));
            result = true ;
        }catch(TimeoutException e){
            System.out.println("The error message is = " + e.getMessage()  );
        }

        return result ;

    }


    //switches to window by title. if given window not found -returns original window
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }


    //hovers over given elm
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }


    //return text of each web element from given list of web elements
    public static List<String> getAllText(List<WebElement> lstOfWebElements ){

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;

    }


    // waits until elm is clickable
    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    // waits for a page to load
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }


    //performs fluent wait on given elm
    public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeinsec))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }


    //checks if elm is displayed on page
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: "+element, element.isDisplayed());
            System.out.println("assert true is right");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
            System.out.println("element not found");

        }
    }


    //waits until elm isn't stale
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if(y==1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


    //returns random value from a dropdown list
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }


    //click elm using Javascript
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    //scroll down to an elm using JS
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //performs double click
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }


    //Changes the HTML attribute of a Web Element to the given value using JavaScript
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }


    // returns true if elm is clickable
    public static boolean isClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));

        }catch(Exception e){
            return false;
        }
        return true;
    }


}


