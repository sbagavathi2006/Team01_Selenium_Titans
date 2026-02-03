package utilities;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactorySetUp.DriverFactory;


public class CommonMethods {
	  public static WebDriver driver;
	   public static WebDriverWait wait;
	  
	   public CommonMethods(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	public  WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

       public  WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
       public static String generateRandomString() {
           String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
           StringBuilder salt = new StringBuilder();
           Random rnd = new Random();
           while (salt.length() < 10) { // random string length
               int index = rnd.nextInt(CHARSET.length());
               salt.append(CHARSET.charAt(index));
           }
           return salt.toString();
       }
       
       
       public boolean isDisplayed(By locator) {
    	   try {
               return waitForVisibility(locator).isDisplayed();
           } catch (Exception e) {
               return false;
           }
       }
       
       public String getText(By locator) {
           return waitForVisibility(locator).getText().trim();
       }
       
       public void click(By locator) {
	        waitForClickable(locator).click();
	    }


    public static boolean webClickByLocator(By locator) {
        // Implementation of the Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);

        try {
            WebElement element = fluentWait.until(d -> d.findElement(locator));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            try {
                Actions action = new Actions(driver);
                action.moveToElement(element).click().perform();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
            return true;
        } catch (Exception e) {
            System.err.println("Failed to click element after Fluent Wait: " + locator);
            return false;
        }
    }
    public static String waitForDomAttribute(By locator, String attribute, int timeoutInSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(driver -> driver.findElement(locator).getDomAttribute(attribute));
	    } catch (Exception e) {
	        LoggerLoad.error("Failed to get DOM attribute '" + attribute + "' for element: " 
	                         + locator + ". Exception: " + e.getMessage());
	        return "";
	    }
	}    
       
}
