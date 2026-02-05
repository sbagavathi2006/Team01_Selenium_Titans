package utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import driverFactorySetUp.DriverFactory;


public class CommonMethods {
	  public static WebDriver driver;
	   public static WebDriverWait wait;
	  
	   public CommonMethods(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	public static WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public static WebElement waitForVisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    
    public WebElement waitForClickable(By activityInsightBtn) {
        return wait.until(ExpectedConditions.elementToBeClickable(activityInsightBtn));
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
       

       
       public boolean isDisplayed(By locator) {
    	   try {
               return waitForVisibility(locator).isDisplayed();
           } catch (Exception e) {
               return false;
           }
       }
       
       public boolean isEnabled(By locator) {
    	   try {
               return waitForVisibility(locator).isEnabled();
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
  
    public void waitForPopupToDisappear() {
    	try {
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(
    				By.xpath("//li[@role='status']") 
    				));
    } catch (Exception e) { 
    	LoggerLoad.info("Pop up cannot be closed");
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
       
       public int getElementsCount(By locator) {
           return driver.findElements(locator).size();
       }

       
       public List<String> getElementsListText(By locator) {

    	    List<WebElement> elements = driver.findElements(locator);
    	    List<String> texts = new ArrayList<>();

    	    for (WebElement element : elements) {
    	        String text = element.getText().trim();
    	        if (!text.isEmpty()) {
    	            texts.add(text);
    	        }
    	    }
    	
    	    return texts;
    	}   
     
       public static int generateRandomAge() {
    	    return new Random().nextInt(83) + 18;
       }

    public static double extractNumber(String text) {
        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
    }
    
  

    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    
    public void enterTextAndAcceptAlert(String text) {
    	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    	        alert.sendKeys(text);
    	    alert.accept();
    }
    
    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }


    public static void sendKeys(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

}



