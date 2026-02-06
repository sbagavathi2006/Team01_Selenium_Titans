package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import context.TestContextSetup;
import utilities.CommonMethods;
import utilities.LoggerLoad;

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
	private By radioBtnsText = By.xpath("//span[@class = 'text-[#6A5ACD]']");
	private By inputBox = By.xpath("//input");
	private By fieldLabels = By.xpath("//label");
	private By fieldLabelsDescs = By.xpath("//p[contains(@class , 'text-xs')]");
	private By headerDesc = By.xpath("//p[contains (text() , 'personalize your experience')]");
	private By firstName = By.id("name");
	private By age = By.id("age");
	private By errMsg = By.xpath("//p[text() ='Please select your blood pressure status']");
	
	
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
		CommonMethods.waitForVisibility(btnContinue);
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
	
	public void enterFirstName(String string) {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(string);
	}
		
	public void enterValidAge(String string) {
		driver.findElement(age).clear();
		driver.findElement(age).sendKeys(string);

	}
	
	public void enterInvalidAge(String string) {		
		driver.findElement(age).clear();
		driver.findElement(age).sendKeys(string);
	}
	
	public void clickBtnContinueStep4() {
    
	    WebElement continueBtn = comMethods.waitForClickable(btnContinue);	    
        comMethods.scrollIntoView(continueBtn);
	    try {
	        comMethods.waitForClickable(btnContinue).click();
	    } catch (ElementClickInterceptedException e) {
	        comMethods.scrollIntoView(continueBtn);
	        continueBtn.click();
	    }
	    
	}
	
	public String alertMsgValidationName() {
		return comMethods.getAlertMsg(firstName);
	}
	
	public String alertMsgValidationAge() {
		return comMethods.getAlertMsg(age);
	}
	
	public boolean errMsgValidationBPStatus() {
		return comMethods.isDisplayed(errMsg);
	}
	
	public void clickBtnBackStep4() {
		comMethods.click(btnBack);
	}
	
	public void randomBPStatusSelection(TestContextSetup testContext) {
		WebElement selectedBPStatus = comMethods.randomCheckboxSelection(radioBtnsText);

		String text = selectedBPStatus.getText().trim();
		LoggerLoad.info("Selected BPStatus: => " + text);
		testContext.setScenarioData("BPSTATUS", text);
		
		comMethods.scrollIntoView(selectedBPStatus);
		
		try {
	    selectedBPStatus.click();
		} catch (ElementClickInterceptedException e) {
	        comMethods.scrollIntoView(selectedBPStatus);
		    selectedBPStatus.click();
		}
		
	}

}
