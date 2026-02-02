package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnBoarding1Page {
	
    WebDriver driver;
    
    public OnBoarding1Page(WebDriver driver) {
        this.driver = driver;
    }	  
    
    private By btnSignUp = By.xpath("//button[text()='Sign Up']");
    private By emailID = By.id(":r5:-form-item");
    private By pwd = By.name("password");
    private By confpwd = By.name("confirmPassword");
    private By termCondi = By.id(":r8:-form-item");
	private By btnRegister = By.xpath("//button[text()='Register']");
	private By pageTitle = By.xpath("//h2[text() ='Upload Your Recent Blood Work']");
	private By supportingText =  By.xpath("//p[contains(text(), 'Welcome to')]");
	private By onboardingProgress = By.xpath("//span[text() = 'Onboarding Progress']");
	private By currentStep1 = By.xpath("//span[text() = '1' and text() = '10']");	
	private By btnUploadPDF = By.xpath("//button[text() = 'Upload PDF']");
	private By pdfFileSize = By.xpath("//p[text() = 'PDF files only (Max 10MB)']");
	private By skipNow = By.xpath("//h3[text() = 'Skip for Now']");
	private By skipNowText = By.xpath("//p[contains(text(), 'continue without uploading')]");
	private By btnContWithOutReport = By.xpath("//button[text() = 'Continue Without Report']");
	private By secNote = By.xpath("//p[contains(text(), ' third parties')]");	

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
	
	public void isOBPage1TitleDisplayed() {
		driver.findElement(pageTitle).isDisplayed();
	}
	
	public void isSupportingTextDisplayed() {
		driver.findElement(supportingText).isDisplayed();
	}
	
	public void isOnBoardingProgressDisplayed() {
		driver.findElement(onboardingProgress).isDisplayed();
	}
	
	public void isProgressBar1_10Displayed() {
		driver.findElement(currentStep1).isDisplayed();
	}
	
	public void isUploadBtnDisplayed() {
		driver.findElement(btnUploadPDF).isDisplayed();
	}
	
	public void isUploadBtnEnabled() {
		driver.findElement(btnUploadPDF).isEnabled();
	}
	
	public void isMax10MBDisplayed() {
		driver.findElement(pdfFileSize).isDisplayed();
	}
	
	public void isSkipNowCardDisplayed() {
		driver.findElement(skipNow).isDisplayed();
	}
	
	public void isskipNowTextDisplayed() {
		driver.findElement(skipNowText).isDisplayed();
	}
	
	public void isContWithOutReportBtnDisplayed() {
		driver.findElement(btnContWithOutReport).isDisplayed();
	}
	
	public void isContWithOutReportBtnEnabled() {
		driver.findElement(btnContWithOutReport).isEnabled();
	}
	
	public void issecNoteDisplayed() {
		driver.findElement(btnContWithOutReport).isDisplayed();
	}
}
