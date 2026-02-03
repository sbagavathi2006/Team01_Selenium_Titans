package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import context.TestContextSetup;
import utilities.CommonMethods;

public class SignUpPage {
	WebDriver driver;
	private TestContextSetup testContext;
	
    public SignUpPage(WebDriver driver, TestContextSetup testContext) {
        this.driver = driver;
        this.testContext = testContext;
    }


	private By btnSignUp = By.xpath("//button[text()='Sign Up']");
	private By emailID = By.id(":r5:-form-item");
	private By pwd = By.name("password");
	private By confpwd = By.name("confirmPassword");
	private By termCondi = By.id(":r8:-form-item");
	private By btnRegister = By.xpath("//button[text()='Register']");
	 
	
	public void clickbtnSignUp() {
        driver.findElement(btnSignUp).click();
	}
	public boolean isBtnSignUpRegisterDisplayed() {
		return  driver.findElement(btnRegister).isDisplayed();
	} 
	
	public void doRegisterForValidData(String email, String password) {		
	String randomString = CommonMethods.generateRandomString();
	System.out.println(randomString);
	email = randomString + "@gmail.com";
	testContext.setScenarioData("EMAIL", email);
	driver.findElement(emailID).sendKeys(email);

	password = randomString;
	testContext.setScenarioData("PASSWORD", password);
	driver.findElement(pwd).sendKeys(password);
	driver.findElement(confpwd).sendKeys(password);

	driver.findElement(termCondi).click();
	driver.findElement(btnRegister).click();
	}
	
}
