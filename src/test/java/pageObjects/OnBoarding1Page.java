package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonMethods;

public class OnBoarding1Page {
	
    WebDriver driver;
	CommonMethods comMethods;

    public OnBoarding1Page(WebDriver driver) {
        this.driver = driver;
		this.comMethods = new CommonMethods(driver);

    }	  

	private By pageTitle = By.xpath("//h2[text() ='Upload Your Recent Blood Work']");
	private By supportingText =  By.xpath("//p[contains(text(), 'Welcome to')]");
	private By currentStep1 = By.xpath("//span[text() = '1' and text() = '10']");	
	private By btnUploadPDF = By.xpath("//button[text() = 'Upload PDF']");
	private By pdfFileSize = By.xpath("//p[text() = 'PDF files only (Max 10MB)']");
	private By skipNow = By.xpath("//h3[text() = 'Skip for Now']");
	private By skipNowText = By.xpath("//p[contains(text(), 'continue without uploading')]");
	private By btnContWithOutReport = By.xpath("//button[text() = 'Continue Without Report']");
	private By secNote = By.xpath("//p[contains(text(), ' third parties')]");
	private By progressBar = By.xpath("//div[contains(@class , 'bg-[#6A5ACD]')]");

	
	public boolean isOBPage1TitleDisplayed() {
		return  driver.findElement(pageTitle).isDisplayed();
	}
	
	public boolean  isSupportingTextDisplayed() {
		return driver.findElement(supportingText).isDisplayed();
	}
	
	public boolean isOnBoardingProgressDisplayed() {
		return driver.findElement(progressBar).isDisplayed();
	}
	
	public boolean isProgressBar1_10Displayed() {
		return driver.findElement(currentStep1).isDisplayed();
	}
	
	public void clickContWithOutRt() {
		driver.findElement(btnContWithOutReport).click();
	}
	
	public boolean isUploadBtnDisplayed() {
		return driver.findElement(btnUploadPDF).isDisplayed();
	}
	
	public boolean isUploadBtnEnabled() {
		return driver.findElement(btnUploadPDF).isEnabled();
	}
	
	public boolean isMax10MBDisplayed() {
		return driver.findElement(pdfFileSize).isDisplayed();
	}

	public WebElement getSkipNowCard() {
        return CommonMethods.waitForVisibility(skipNow);
    }
	
	public boolean isskipNowTextDisplayed() {
		return driver.findElement(skipNowText).isDisplayed();
	}
	
	public WebElement getContWithOutReportBtn() {
        return CommonMethods.waitForVisibility(btnContWithOutReport);
    }
	
	public boolean isContWithOutReportBtnDisplayed() {
		return driver.findElement(btnContWithOutReport).isDisplayed();
	}
	
	public boolean isContWithOutReportBtnEnabled() {
		return driver.findElement(btnContWithOutReport).isEnabled();
	}
	

	
	public boolean issecNoteDisplayed() {
		return driver.findElement(secNote).isDisplayed();
	}
}
