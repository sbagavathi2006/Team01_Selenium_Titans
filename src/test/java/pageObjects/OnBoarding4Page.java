package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class OnBoarding4Page {
	WebDriver driver;
	CommonMethods comMethods;
	
    public OnBoarding4Page(WebDriver driver) {
        this.driver = driver;
        this.comMethods = new CommonMethods(driver);
    }	
    
	private By currentStep4 = By.xpath("//span[text() = '4' and text() = '10']");
	private By currentStep5 = By.xpath("//span[text() = '5' and text() = '10']");
	private By progressBar = By.xpath("//div[contains(@class , 'bg-[#6A5ACD]')]");
	private By pageHeader = By.xpath("//h2[text() ='Menstrual Cycle Awareness']");
	private By btnBack = By.xpath("//button[text() ='Back']");
	private By btnContinue = By.xpath("//button[text() ='Continue']");
	private By question = By.xpath("//h3[contains (text() , 'Do you currently track your menstrual cycle')]");
	private By mcaDescText = By.xpath("//p[contains ( text() , 'Understanding your cycle helps us optimize')]");
	private By radiobtns = By.xpath("//div[contains(@class, 'border-2')]");
	private By radioBtnsText = By.xpath("//label[contains(@class , 'text-[#333333]')]");
	
	public boolean isProgressBar4_10Displayed() {
		return driver.findElement(currentStep4).isDisplayed();	
		}
	

	public boolean isCurrentStep5_10Displayed() {
		return comMethods.isDisplayed(currentStep5);
	}
	
	public boolean isProgressBarDisplayed() {
		return comMethods.isDisplayed(progressBar);
	}
	
	public String pageHeader() {
		return driver.findElement(pageHeader).getText().trim();
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
	
	public String pageHeaderDescription() {
		return driver.findElement(mcaDescText).getText().trim();
	}
	
	
	public String pageHeader3() {
		return driver.findElement(question).getText().trim();
	}
	
	public int countOfRadioBtns() {
		return driver.findElements(radiobtns).size();
	}

	public List<String> getRadioBtnsText() {
		CommonMethods.waitForVisibility(radioBtnsText);
		return comMethods.getElementsListText(radioBtnsText);
	}	
}
