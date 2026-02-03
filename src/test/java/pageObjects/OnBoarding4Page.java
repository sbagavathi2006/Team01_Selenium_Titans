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
	private By pageHeader = By.xpath("//h2[text() ='Health Conditions']");
	private By onboardingProgress = By.xpath("//span[text() = 'Onboarding Progress']");
	private By currentStep3 = By.xpath("//span[text() = '3' and text() = '10']");
	private By btnBack = By.xpath("//button[text() ='Back']");
	private By btnContinue = By.xpath("//button[text() ='Continue']");
	private By checkbox9 = By.xpath("//div[contains(@class, 'grid')]//input[@type='checkbox']");
	private By subTitleHeader = By.xpath("//p[text() = 'Want to manually enter any key conditions or comorbidities?']");
	private By note = By.xpath("//p[contains(text(), 'insulin resistance affect')]");
	private By checkbox10 = By.xpath("//input[@type='checkbox']");
	
	
	public boolean isProgressBar3_10Displayed() {
		return driver.findElement(currentStep3).isDisplayed();	
		}
	
	public boolean isOnBoardingProgressDisplayed() {
		return driver.findElement(onboardingProgress).isDisplayed();
	}
	
	public boolean isBackBtnDisplayed() {
		return driver.findElement(btnBack).isDisplayed();
	}
	
	public boolean isBackBtnEnabled() {
		return driver.findElement(btnBack).isEnabled();
	}
	
	public boolean isContinueBtnDisplayed() {
		return driver.findElement(btnBack).isDisplayed();
	}
	
	public boolean isContinueBtnEnabled() {
		return driver.findElement(btnBack).isEnabled();
	}
	
	public boolean isStep3HeaderDisplayed() {
		return driver.findElement(pageHeader).isEnabled();
	}
	
	public boolean isNineRadioBtnDisplayed() {
		return driver.findElement(checkbox9).isDisplayed();
	}
	
	public boolean isInfoNoteDisplayed() {
		return driver.findElement(note).isDisplayed();
	}
	
	
	public boolean isSubTitleHeaderDisplayed() {
		return driver.findElement(subTitleHeader).isDisplayed();
	}
	
	public boolean isCheckBoxTextVisible(String Text) {		
		return driver.findElement(By.xpath("//label[text()='" + Text + "']")).isDisplayed();
	}

}
