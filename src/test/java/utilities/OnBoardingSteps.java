package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnBoardingSteps {
	
WebDriver driver;
    
    public OnBoardingSteps(WebDriver driver) {
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
		public void clickBtnRegister() {
			String randomString = CommonMethods.generateRandomString();
			System.out.println(randomString);
			String email = randomString + "@gmail.com";
			String password = randomString;
		    driver.findElement(emailID).sendKeys(email);
		    driver.findElement(pwd).sendKeys(password);
		    driver.findElement(confpwd).sendKeys(password);
		    driver.findElement(termCondi).click();
		    driver.findElement(btnRegister).click();
		}
		
	public void onboarding_till_step(int stepNumber) {

	    if (stepNumber >= 1) {
	    	clickbtnSignUp();
	    	clickBtnRegister();
	    	
	    }

	 
	  
	}

}
