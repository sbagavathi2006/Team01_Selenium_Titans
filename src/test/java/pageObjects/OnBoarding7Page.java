package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;
import utilities.ExcelUtils;

public class OnBoarding7Page {
	
	private By dropDownKg = By.xpath("//*[@value='kg']");
    private By dropDowncms =By.xpath("//*[text()='cm']");
    private By dropDownlbs = By.xpath("//*[@value='lbs']");
    private By dropDown_ftin = By.xpath("//*[@value='ft/in']");
    private By step7ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
    private By errorforWeight = By.xpath("//*[text()='Weight is required']");
    private By errorforHeight = By.xpath("//*[text()='Height is required']");
    private By weightTextBox = By.xpath("//*[@id='weight']");
    private By heightTextBox = By.xpath(" //*[@id='height']");
    private By errorforInvalidWeight = By.xpath(" //*[contains(text(),'Please enter a valid weight')]");
    private By errorforInvalidHeight = By.xpath("//*[contains(text(),'Please enter a valid height')]");
    private By step7BackButton = By.xpath(" //*[contains(text(),'Back')]");
    private By verify_step8 = By.xpath("//span[normalize-space()='8 of 10']");
    private By headingTextstep8 = By.xpath("//*[contains(text(),'Dietary Preferences')]");
	private By textBelowHeadingstep8= By.xpath("//*[contains(text(),'Let us know about your ')]");
	private By pescatarianSection= By.xpath("//*[contains(text(),'Pescatarian Diet')]");
	private By nonVegetarianSection = By.xpath("//*[contains(text(),'Non-Vegetarian')]");
	private By vegetarianSection= By.xpath("//*[contains(text(),'Vegetarian Diet')]");
	private By veganSection= By.xpath("//*[contains(text(),'Vegan Diet')]");
	private By infoMessage= By.xpath("//*[contains(text(),'Understanding your dietary preferences')]");
	private By step8ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
 
	private WebDriver driver;
	private CommonMethods commonMethods;
	private OnBoarding6Page onBoard6Pg;
	
	 public OnBoarding7Page(WebDriver driver) {
		 this.driver = driver;
		 this.commonMethods = new CommonMethods(driver);
		 this.onBoard6Pg = new OnBoarding6Page(driver);
	}
	 
	 public void clickdropDown() {
		 commonMethods.click(dropDownKg);
	 }
	 
	 public boolean verifyWeightdropDown() {
		  commonMethods.click(dropDownKg);
		  boolean isKgDisplayed = commonMethods.isDisplayed(dropDownKg);
		  boolean isLbsDisplayed = commonMethods.isDisplayed(dropDownlbs);
		  return isKgDisplayed && isLbsDisplayed;	 
		 
	 }
	 public boolean verifyHeightdropDown() {
		  commonMethods.click(dropDowncms);
		  boolean isCmsDisplayed = commonMethods.isDisplayed(dropDowncms);
		  boolean isftDisplayed=commonMethods.isDisplayed(dropDown_ftin);;
		  return isCmsDisplayed && isftDisplayed;	 
		 
	 }
	 public void clickStep7ContinueButton() {
		 driver.findElement(step7ContinueButton).click();
		 
	 }
	 public String errorForWeight() {
			String error= driver.findElement(errorforWeight).getText();
			return error ;
		}
	 public String errorForHeight() {
			String error= driver.findElement(errorforHeight).getText();
			return error ;
		}
	 public String errorForInvalidWeight() {
			String error= driver.findElement(errorforInvalidWeight).getText();
			return error ;
		}
	 public String errorForInvalidHeight() {
			String error= driver.findElement(errorforInvalidHeight).getText();
			return error ;
		}
	 
	 public void enterInputValues(String weight, String height) {
	        driver.findElement(weightTextBox).clear();
	        driver.findElement(weightTextBox).sendKeys(weight);

	        driver.findElement(heightTextBox).clear();
	        driver.findElement(heightTextBox).sendKeys(height);
	        clickStep7ContinueButton();
	    }
	 public void clickBackButtonInstep7() {
		 driver.findElement(step7BackButton).click();
		 
	 }
	 public String  verify_step8(){
			String findStep = driver.findElement(verify_step8).getText();
			return findStep;
			
		}
	 private Map<String, By> step7ElementMap() {
	        Map<String, By> map = new HashMap<>();
	        map.put("Progress bar",verify_step8);
	        map.put("Heading", headingTextstep8);
	        map.put("Description", textBelowHeadingstep8);
	        map.put("Pescatarian Diet section", pescatarianSection);
	        map.put("Non-Vegetarian section", nonVegetarianSection);
	        map.put("Vegetarian Diet section", vegetarianSection);
	        map.put("Vegan Diet section", veganSection);
	        map.put("Info note message", infoMessage);
	        map.put("Continue button",step8ContinueButton );
	        return map;
	    }
	 public boolean verifyStep8Element(String elementName) {
	        By locator = step7ElementMap().get(elementName);
	        if (locator == null) {
	            throw new IllegalArgumentException("No locator found for: " + elementName);
	        }
	        return commonMethods.isDisplayed(locator); // Uses your existing isDisplayed method
	    }
			
	 
}
