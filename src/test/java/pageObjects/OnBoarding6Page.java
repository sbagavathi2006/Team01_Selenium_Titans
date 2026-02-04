package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class OnBoarding6Page {
	
	private WebDriver driver;
	private CommonMethods commonMethods;
	private OnBoarding6Page onBrd6Page;
	
	private By btnSignUp = By.xpath("//button[text()='Sign Up']");
	private By emailID = By.id(":r5:-form-item");
	private By pwd = By.name("password");
    private By confpwd = By.name("confirmPassword");
	private By termCondi = By.id(":r8:-form-item");
	private By btnRegister = By.xpath("//button[text()='Register']");
	private By btnContinueWithoutReport=By.xpath("//button[text() = 'Continue Without Report']");
	private By checkboxSleepApnea = By.xpath("//*[@id='sleep_apnea']");
	private By ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By inputFirstName = By.id("name");
	private By inputAge=By.id("age");
	private By checkbox_Ihave_never_diagnosed=By.xpath("//*[contains(text(),'I have never been diagnosed')]");
	private By checkbox_no=By.id("no");
	private By backButton = By.xpath("//*[contains(text(),'Back')]");
    private By Error_without_mensuraldate = By.xpath("//*[contains(text(),'Please select your last period start date')]");
	private By verify_step5 = By.xpath("//span[normalize-space()='5 of 10']");
	private By calenderToSelect = By.xpath("//*[@type='date']");
	private By messageRelated_LastPeriod = By.xpath("//*[contains(text(), 'Based on your last period')]");
	private By description_CurrentPhase =  By.xpath("//*[contains(text(),'This phase influences')]");
	private By section_Header1 = By.xpath("//*[contains(text(),'Your Cycle Timeline')]");
	private By section_Header2 = By.xpath("//*[contains(text(),'Your Upcoming Cycle Calendar')]");
	private By section_Header3 = By.xpath("//*[contains(text(),'Your Next Expected Periods')]");
	private By phase_Details_DayCount = By.xpath("//h5[contains(normalize-space(.), ' (Day ')]");
	private By current_PhaseGuidance  =By.xpath("//*[contains(text(),'Your metabolism')]");
	private By calendar = By.className("rdp-months");
	private By verify_step7 = By.xpath("//span[normalize-space()='7 of 10']");
	private By headingText = By.xpath("//*[contains(text(),'Current Weight and Height')]");
	private By textBelowHeading= By.xpath("//*[contains(text(),'This helps us calculate')]");
	private By inputField1= By.xpath("//*[@id='weight']");
	private By inputField2= By.xpath("//*[@id='height']");
	private By question1= By.xpath("//*[contains(text(),'current weight?')]");
	private By question2= By.xpath("//*[contains(text(),'your height?')]");
	private By verify_step6 = By.xpath("//span[normalize-space()='6 of 10']");
	
	
	 public OnBoarding6Page(WebDriver driver) {
		 this.driver = driver;
		 this.commonMethods = new CommonMethods(driver);
		
	}	
	 
	 public void clickBtnRegister(String email, String password) {
		    driver.findElement(emailID).sendKeys(email);
		    driver.findElement(pwd).sendKeys(password);
		    driver.findElement(confpwd).sendKeys(password);
		    commonMethods.click(termCondi);
		    commonMethods.click(btnRegister);
		}
		
	 public void continueToStep1_2(){
		    commonMethods.click(btnSignUp);
			String randomString = CommonMethods.generateRandomString();
			System.out.println(randomString);
			String email = randomString + "@gmail.com";
			LoggerLoad.info("On boarding started for the emailid: " +email);
			String password = randomString;
			clickBtnRegister(email, password);
			
		}
	 public void continueToStep3() {
			commonMethods.waitForClickable(btnContinueWithoutReport);
			commonMethods.click(btnContinueWithoutReport);
	    
		}
		public void continueToStep4() {
		    driver.findElement(checkboxSleepApnea).click();
		    try {
		        Thread.sleep(5000); // Handle InterruptedException locally
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		   commonMethods.waitForClickable(ContinueButton);
		   commonMethods.click(ContinueButton);
		}
		public void continueToStep5() {
			String randomString = CommonMethods.generateRandomString();
			System.out.println(randomString);
			String firstname = randomString;
			driver.findElement(inputFirstName).sendKeys(firstname);
			int age = CommonMethods.generateRandomAge();
			driver.findElement(inputAge).sendKeys(String.valueOf(age));
			driver.findElement(checkbox_Ihave_never_diagnosed).click();
			commonMethods.click(ContinueButton);
			commonMethods.click(checkbox_no);
			commonMethods.click(ContinueButton);	
	        
		}
		
		public void  clickContinueButton(){
			commonMethods.click(ContinueButton);		
			
		}
		public void onBoarding_step(int n) {
	    	if(n>=5) {
	    	continueToStep1_2();
			LoggerLoad.info("On boarding for step1&2 is succesfull");
			continueToStep3();
			LoggerLoad.info("On boarding for step3 is succesfull");
			continueToStep4();
			LoggerLoad.info("On boarding for step4 is succesfull");
			continueToStep5();
			LoggerLoad.info("On boarding for step5 is succesfull");
			
	    }
	   if(n>=6)
	   {
		   
	    	LoggerLoad.info("On boarding for step6 is succesfull");
	    	
	    }
	   
		}
		
		
		public void click_step6back_button() {
			commonMethods.click(backButton);
		}
		
		public String  verify_step6back_button(){
			return commonMethods.getText(verify_step5);
			
		}
		public String  verify_step7back_button(){
			return commonMethods.getText(verify_step6);
			
		}
		public void passingDate(String date) {
		    WebElement calendar = driver.findElement(calenderToSelect);
		    calendar.sendKeys(date);
		    
		}
		
		public String Error_without_mensuraldate() {
			return commonMethods.getText(Error_without_mensuraldate);
			
		}
		private Map<String, By> step6ElementMap() {
		    Map<String, By> map = new HashMap<>();

		    map.put("Message related to last period date", messageRelated_LastPeriod);
		    map.put("Description for current phase", description_CurrentPhase);
		    map.put("Section headers1", section_Header1);
		    map.put("Section headers2", section_Header2);
		    map.put("Section headers3", section_Header3);// header presence check
		    map.put("Phase details with day count", phase_Details_DayCount);
		    map.put("Current phase guidance",current_PhaseGuidance );
		    map.put("Calendar", calendar);

		    return map;
		}

		public boolean verifyUIElements_forStep6(String elementName) {
		    By locator = step6ElementMap().get(elementName);
		    if (locator == null) {
		        throw new IllegalArgumentException("No locator found for: " + elementName);
		    }

		    return commonMethods.isDisplayed(locator);
		}
		
		private Map<String, By> step7ElementMap() {
	        Map<String, By> map = new HashMap<>();
	        map.put("Progress bar", verify_step7);
	        map.put("Heading", headingText);
	        map.put("Description", textBelowHeading);
	        map.put("Weight input field", inputField1);
	        map.put("Height input field", inputField2);
	        map.put("Weight question", question1);
	        map.put("Height question", question2);
	        return map;
	    }

	    // Verify single element
	    public boolean verifyStep7Element(String elementName) {
	        By locator = step7ElementMap().get(elementName);
	        if (locator == null) {
	            throw new IllegalArgumentException("No locator found for: " + elementName);
	        }
	        return commonMethods.isDisplayed(locator); // Uses your existing isDisplayed method
	    }
	    
	    
	    
	    }
		

