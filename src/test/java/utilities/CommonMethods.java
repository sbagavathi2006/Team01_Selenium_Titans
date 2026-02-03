package utilities;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	  WebDriver driver;
	   static WebDriverWait wait;
	  
	   public CommonMethods(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	public static WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

       public WebElement waitForPresence(By locator) {
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
}
