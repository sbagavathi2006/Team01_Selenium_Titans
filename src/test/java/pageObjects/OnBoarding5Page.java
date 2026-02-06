package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding5Page {
	
	WebDriver driver;
	CommonMethods comMethods;
	
    public OnBoarding5Page(WebDriver driver) {
        this.driver = driver;
        this.comMethods = new CommonMethods(driver);
    }
	
	private By Step5 = By.xpath("//span[text() = '5' and text() = '10']");
	private By currentStep6 = By.xpath("//span[text() = '6' and text() = '10']");
	private By btnContinue = By.xpath("//button[text() ='Continue']");
	private By progressBar = By.xpath("//div[contains(@class , 'bg-[#6A5ACD]')]");
	private By btnBack = By.xpath("//button[text() ='Back']");
	private By slider = By.id("cycle-length");
	private By calendarIcon = By.xpath("//input[@type = 'date']");
	private By radioBtnsText = By.xpath("//label[contains(@class , 'text-[#333333]')]");
	private By header = By.xpath("//h2[text() ='Last Period Date']");
	private By headerDesc = By.xpath("//p[contains (text() , 'understand your current cycle phase and tailor')]");
	private By question = By.xpath("//h3[contains (text() , 'did your last menstrual period start?')]");
	private By cycleLengthText = By.xpath("//label[contains ( text() , 'Cycle Length (days)')]");
	private By infoText = By.xpath("//p[contains ( text() , 'but can vary from 21 to 45 days')]");
	private By errMsg = By.xpath("//p[text() ='Please select your menstrual cycle track']");
	private By cycleLength = By.xpath("//span[text() ='28']");
	
	
	public boolean isStep5_10Displayed() {
		return comMethods.isDisplayed(Step5);
	}
	
	public boolean isStep6_10Displayed() {
		return comMethods.isDisplayed(currentStep6);
	} 
	
	 public void generateRandomMenstrualCycle(TestContextSetup testContext) {

	 }
	   
	public void clickBtnContinueStep5(TestContextSetup testContext) {		
	        driver.findElement(btnContinue).click();
		} 
	
	public String getMenstrualCycleErrorMessage() {
	    return driver.findElement(errMsg).getText().trim();
	}
	
	public void clickBtnContinueRandomMenstrualCycle(TestContextSetup testContext){
			WebElement selectedMenstrualCycle = comMethods.randomCheckboxSelection(radioBtnsText);

			String text = selectedMenstrualCycle.getText().trim();
			LoggerLoad.info("Selected MenstrrualCycle Info: => " + text);
			testContext.setScenarioData("MENSTRUAL_CYCLE_IFO", text);
			selectedMenstrualCycle.click();
		    comMethods.scrollIntoView(btnContinue);	  
	        comMethods.waitForClickable(btnContinue).click();	
	}
	    
	
	
	public  Map<String, By> displayElementMap() {
	    Map<String, By> map = new HashMap<>();

	    map.put("Onboarding progress bar", currentStep6);
	    map.put("Progress bar shows the current step as  6of11", progressBar);
	    map.put("Back button", btnBack);
	    map.put("Continue button", btnContinue);
	    map.put("Slider control for cycle length", slider);
	    map.put("Calendar icon", calendarIcon);
	    map.put("understand your current cycle phase and tailor", headerDesc);
	    map.put("did your last menstrual period start?", question);
	    map.put("but can vary from 21 to 45 days", infoText);
   
	    return map;
	}
	
	public boolean verifyElementDisplay(String element) {
	    By locator = displayElementMap().get(element);
	    if (locator == null) {
	        throw new IllegalArgumentException("No locator found for: " + element);
	    }

	    return comMethods.isDisplayed(locator);
	}
	
	public  Map<String, By> enableElementMap() {
	    Map<String, By> map = new HashMap<>();

	    map.put("Back button", btnBack);
	    map.put("Continue button", btnContinue);
	   
	    return map;
	}
	
	public boolean verifyElementEnabled(String element) {
	    By locator = displayElementMap().get(element);
	    if (locator == null) {
	        throw new IllegalArgumentException("No locator found for: " + element);
	    }

	    return comMethods.isEnabled(locator);
	}
	
	public  Map<String, By> matchElementMap() {
	    Map<String, By> map = new HashMap<>();

	    map.put("Last Period Date", header);
	    map.put("Cycle Length (days)", cycleLengthText);
	    map.put("28", cycleLength);
	   
	    return map;
	}
	
	public String GetElemenToMatch(By element) {
		CommonMethods.waitForVisibility(element);
	    return driver.findElement(element).getText().trim();
	}
	
	public void clickBackBtn() {
		driver.findElement(btnBack).click();
	}
	
}
