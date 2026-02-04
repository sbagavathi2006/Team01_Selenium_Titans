package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;

public class OnBoarding3FnPage {

	WebDriver driver;
	CommonMethods comMethods;
	
	public OnBoarding3FnPage(WebDriver driver) {
		this.driver = driver;
		this.comMethods = new CommonMethods(driver);
	}

	private By currentStep4 = By.xpath("//span[text() = '4' and text() = '10']");
	private By pageHeader = By.xpath("//h2[text() ='Personal Details']");
	private By onboardingProgress = By.xpath("//span[text() = 'Onboarding Progress']");
	private By btnBack = By.xpath("//button[text() ='Back']");
	private By btnContinue = By.xpath("//button[text() ='Continue']");
	private By radiobtns = By.xpath("//div[contains(@class, 'border-2')]");
	private By inputBox = By.xpath("//input");
	private By fieldLabels = By.xpath("//label");
	private By fieldLabelsDescs = By.xpath("//p[contains(@class , 'text-xs')]");
	private By headerDesc = By.xpath("//p[contains (text() , 'personalize your experience')]");

	public boolean isProgressBar4_10Displayed() {
		return comMethods.isDisplayed(currentStep4);	
		}
	
	public boolean isOnBoardingProgressBarDisplayed() {
		return comMethods.isDisplayed(onboardingProgress);
	}
	
	public boolean isBackBtnDisplayed() {
		return comMethods.isDisplayed(btnBack);
	}
	
	public boolean isBackBtnEnabled() {
		return comMethods.isEnabled(btnBack);
	}
	
	public boolean isContinueBtnDisplayed() {
		return comMethods.isDisplayed(btnContinue);
	}
	
	public boolean isContinueBtnEnabled() {
		return comMethods.isEnabled(btnContinue);
	}
	
	public boolean isStep4HeaderDisplayed() {
		return comMethods.isEnabled(pageHeader);
	}
	
	public int countInputBoxes() {
		return comMethods.getElementsCount(inputBox);
	}
	
	public boolean isDescriptionDisplayed() {
		return comMethods.isDisplayed(headerDesc);
	}
	
	public List<String> getFieldLabelList() {	
		CommonMethods.waitForVisibility(fieldLabels);
		return comMethods.getElementsListText(fieldLabels);
	}
	
	
	public List<String> getFieldLabelDescList(){
		CommonMethods.waitForVisibility(fieldLabelsDescs);
		return comMethods.getElementsListText(fieldLabelsDescs);
	}
	
	public boolean isfieldLabelDisplayed(String labels){		
		WebElement helperTextElement  = driver.findElement(By.xpath("//label[contains(text(), '" + labels + "')]"));
		CommonMethods.waitForVisibility(helperTextElement).isDisplayed();
		return helperTextElement.isDisplayed();
	}
	
	public boolean isRadioButtonDisplayed() {
		return comMethods.isDisplayed(radiobtns);
	}
	
	public boolean isradioBtnTextsDisplayed(String text) {
		WebElement radioBtnTextElement  = driver.findElement(By.xpath("//span[contains(text() , '" + text + "')]"));
		return CommonMethods.waitForVisibility(radioBtnTextElement).isDisplayed();	
	}
}
