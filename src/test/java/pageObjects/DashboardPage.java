package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.CommonMethods;

public class DashboardPage {

	private WebDriver driver;
	private CommonMethods commonMethods;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.commonMethods = new CommonMethods(driver);
		}
	
	// temporary login locators
	By emailId = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//button[text()='LogIn']");
	    
	By dashboardTitle = By.xpath("//*[contains(text(), 'Free Plan Dashboard')]");
	By activityInsightsSubTab = By.xpath("//*[contains(text(),'Activity Insights')]");
	
	
	    //***********temporary login flow
	    
	   public void tempLogin() {
		   driver.findElement(emailId).sendKeys("mathumqa@gmail.com");
		   driver.findElement(password).sendKeys("Success@1");
		   driver.findElement(loginButton).click();	   
	   }
	   
	   
	   public String getTitle() {
		return driver.findElement(dashboardTitle).getText();	   
	   }
	   
	   
	   public void clickTrackWeight() {
		   driver.findElement(activityInsightsSubTab).click();
		   
	   }
	   

		
}
