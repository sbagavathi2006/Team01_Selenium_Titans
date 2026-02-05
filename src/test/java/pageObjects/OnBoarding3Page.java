package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.LoggerLoad;

public class OnBoarding3Page {
	
	WebDriver driver;
	CommonMethods comMethods;
    
    public OnBoarding3Page(WebDriver driver) {
        this.driver = driver;
        this.comMethods = new CommonMethods(driver);
    }	  
    
	private By pageHeader = By.xpath("//h2[text() ='Health Conditions']");
	private By onboardingProgress = By.xpath("//span[text() = 'Onboarding Progress']");
	private By currentStep3 = By.xpath("//span[text() = '3' and text() = '10']");
	private By btnBack = By.xpath("//button[text() ='Back']");
	private By btnContinue = By.xpath("//button[text() ='Continue']");
	private By checkbox9 = By.xpath("//div[contains(@class, 'grid')]//input[@type='checkbox']");
	private By subTitleHeader = By.xpath("//p[text() = 'Want to manually enter any key conditions or comorbidities?']");
	private By note = By.xpath("//p[contains(text(), 'insulin resistance affect')]");
	private By checkboxes = By.xpath("//label[contains(@class, 'text-[#333333]')]");
	
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
		CommonMethods.waitForVisibility(btnContinue);
		return driver.findElement(btnContinue).isDisplayed();
	}
	
	public boolean isContinueBtnEnabled() {
		return driver.findElement(btnContinue).isEnabled();
	}
	
	public  void clickBtnContinue(TestContextSetup testContext) {
		List<WebElement> checkboxesNew = driver.findElements(checkboxes);
		Random random = new Random();
		int randomIndex = random.nextInt(checkboxesNew.size());
		WebElement randomCheckbox = checkboxesNew.get(randomIndex);
		
	    String selectedHealthCondition = randomCheckbox.getText().trim();
	    LoggerLoad.info("Selected Health Condition: => " + selectedHealthCondition);

		randomCheckbox.click();

		testContext.setScenarioData("HC", selectedHealthCondition);
		driver.findElement(btnContinue).click();		
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
