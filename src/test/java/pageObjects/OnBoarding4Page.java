package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoarding4Page {
	
	WebDriver driver;
    
    public OnBoarding4Page(WebDriver driver) {
        this.driver = driver;
    }	  
    
    private By btnSignUp = By.xpath("//button[text()='Sign Up']");
    private By emailID = By.id(":r5:-form-item");

	private By currentStep3 = By.xpath("//span[text() = '3' and text() = '10']");	

	public boolean isProgressBar3_10Displayed() {
		return driver.findElement(currentStep3).isDisplayed();	
		}
}
