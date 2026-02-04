package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding6Page {
	
	private By btnSignUp = By.xpath("//button[text()='Sign Up']");
    private By emailID = By.id(":r5:-form-item");
    private By pwd = By.name("password");
    private By confpwd = By.name("confirmPassword");
    private By termCondi = By.id(":r8:-form-item");
	private By btnRegister = By.xpath("//button[text()='Register']");
	private By btnContinueWithoutReport=By.xpath("//button[text() = 'Continue Without Report']");
	private By checkboxSleepApnea = By.xpath("//*[@id='sleep_apnea']");
	private By step3ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By inputFirstName = By.id("name");
	private By inputAge=By.id("age");
	private By checkbox_Ihave_never_diagnosed=By.xpath("//*[contains(text(),'I have never been diagnosed')]");
	private By step4ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By checkbox_no=By.id("no");
	private By step5ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By step6ContinueButton = By.xpath("//*[contains(text(),'Continue')]");
	private By Error_without_mensuraldate = By.xpath("//*[contains(text(),'Please select your last period start date')]");
	private By step6BackButton = By.xpath("//*[contains(text(),'Back')]");
	private By verify_step5 = By.xpath("//span[normalize-space()='5 of 10']");
	private WebDriver driver;
	private CommonMethods commonMethods;
	
	

	 public OnBoarding6Page(WebDriver driver) {
		 this.driver = driver;
		 this.commonMethods = new CommonMethods(driver);
	}
	 public void clickbtnSignUp() {
	        driver.findElement(btnSignUp).click();
		}
		
		public void clickBtnRegister(String email, String password) {
			
		    driver.findElement(emailID).sendKeys(email);
		    driver.findElement(pwd).sendKeys(password);
		    driver.findElement(confpwd).sendKeys(password);
		    driver.findElement(termCondi).click();
		    driver.findElement(btnRegister).click();
		}
		
		public void continueToStep1_2(){
			clickbtnSignUp();
			String randomString = CommonMethods.generateRandomString();
			System.out.println(randomString);
			String email = randomString + "@gmail.com";
			LoggerLoad.info("On boarding started for the emailid: " +email);
			String password = randomString;
			clickBtnRegister(email, password);
			
		}
		
		
		public void continueToStep3() {
			commonMethods.waitForClickable(btnContinueWithoutReport);
	        driver.findElement(btnContinueWithoutReport).click();
		}
		public void continueToStep4() {
		    driver.findElement(checkboxSleepApnea).click();
		    try {
		        Thread.sleep(5000); // Handle InterruptedException locally
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		    WebElement step3Button = commonMethods.waitForClickable(step3ContinueButton);
		    step3Button.click();
		}
		public void continueToStep5() {
			String randomString = CommonMethods.generateRandomString();
			System.out.println(randomString);
			String firstname = randomString;
			driver.findElement(inputFirstName).sendKeys(firstname);
			int age = CommonMethods.generateRandomAge();
			driver.findElement(inputAge).sendKeys(String.valueOf(age));
			driver.findElement(checkbox_Ihave_never_diagnosed).click();
			driver.findElement(step4ContinueButton).click();
			driver.findElement(checkbox_no).click();
			driver.findElement(step5ContinueButton).click();	
	        
		}
		public void clickstep6ContinueButton() {
			driver.findElement(step6ContinueButton).click();
		}
		public String Error_without_mensuraldate() {
			String error= driver.findElement(Error_without_mensuraldate).getText();
			return error ;
		}
		public void click_step6back_button() {
			driver.findElement(step6BackButton).click();
		}
		
		public String  verify_step6back_button(){
			String findStep = driver.findElement(verify_step5).getText();
			return findStep;
			
		}
	

}
